package system_payment_contracts_tests;

import org.junit.*;
import system_payment_contracts_core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemPaymentContractsTests extends Assert {
    @Test
    public void create_CreatePaymentContracts_ContractsCountEqualsZero() {
        SystemContracts paymentContractsList = SystemContracts.create();
        assertEquals(0, paymentContractsList.getContractsCount());
    }
    @Test
    public void addContract_AddContractWithNumberAndDate_ContractsCountEqualsOne() {
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number", "YYYYMMDD");
        assertEquals(1, paymentContractsList.getContractsCount());
    }
    @Test
    public void addContract_AddContractWithNullNumber_ThrowsException() {
        SystemContracts paymentContractsList = SystemContracts.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> paymentContractsList.addContract(null, "YYYYMMDD"));
        assertTrue(exc.getMessage().toLowerCase().contains("number can not be null"));
    }
    @Test
    public void addContract_AddContractWithNullDate_ThrowsException() {
        SystemContracts paymentContractsList = SystemContracts.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> paymentContractsList.addContract("name", null));
        assertTrue(exc.getMessage().toLowerCase().contains("date can not be null"));
    }
    @Test
    public void addContract_AddContractWithNullNumberAndNullDate_ThrowsException() {
        SystemContracts paymentContractsList = SystemContracts.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> paymentContractsList.addContract(null, null));
        assertTrue(exc.getMessage().toLowerCase().contains("number can not be null") &&
                exc.getMessage().toLowerCase().contains("date can not be null"));

    }
    @Test
    public void registerPaymentDocument_registerPayDocumentWithData_PaymentDocumentCountEqualsOne(){
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        assertEquals(1,paymentContractsList.getContracts().get("number").getDocumentsCount());
    }
    @Test
    public void registerPaymentDocument_registerPayDocumentWithData_PaymentDocumentCountEqualsTwo(){
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(200, 2, DocumentType.BankOrder,"number", "YYYYMMDD");
        assertEquals(2,paymentContractsList.getContracts().get("number").getDocumentsCount());
    }
    @Test
    public void getPayments_getPaymentsListOfContract_gotPaymentsList() {
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(200, 2, DocumentType.BankOrder,"number", "YYYYMMDD");
        paymentContractsList.addContract("number1","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(300, 1, DocumentType.PaymentOrder,"number1", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(400, 2, DocumentType.BankOrder,"number1", "YYYYMMDD");
        ArrayList<Integer> payments = new ArrayList<>();
        payments.add(100);
        payments.add(200);

        assertArrayEquals(payments.toArray(), paymentContractsList.getContracts().get("number").getPaymentsList().toArray());
    }
    @Test
    public void getSum_CalculatePaymentsSumByNumberOfContract_SumEqualsThreeHundred(){
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(200, 2, DocumentType.BankOrder,"number", "YYYYMMDD");
        assertEquals(300, paymentContractsList.getContracts().get("number").getPaymentsSum());
    }
    @Test
    public void deletePaymentDoc_DeletePaymentDocWithDocNumberNumberAndDate_PaymentDocCountEqualsZero(){
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(200, 2, DocumentType.BankOrder,"number", "YYYYMMDD");
        paymentContractsList.deletePayment( 1, "number", "YYYYMMDD");
        paymentContractsList.deletePayment( 2, "number", "YYYYMMDD");
        assertEquals(0, paymentContractsList.getContracts().get("number").getDocumentsCount());
    }
    @Test
    public void getLists_GetContractsListAndPaymentsList_ListsEqualMap(){
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(200, 2, DocumentType.BankOrder,"number", "YYYYMMDD");
        paymentContractsList.addContract("number1","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(300, 1, DocumentType.PaymentOrder,"number1", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(400, 2, DocumentType.BankOrder,"number1", "YYYYMMDD");
        List<String> contractsList = new ArrayList();
        List<Integer> paymentsList = new ArrayList();
        contractsList.add("number");
        paymentsList.add(300);
        contractsList.add("number1");
        paymentsList.add(700);
        HashMap<String,Integer> contractsWithPayments = paymentContractsList.getAllContractsAndPayments();
        List<String> contract = new ArrayList();
        List<Integer> payment = new ArrayList();
        for (Map.Entry<String, Integer> entry: contractsWithPayments.entrySet()){
            contract.add(entry.getKey());
            payment.add(entry.getValue());
        }
        assertArrayEquals(contractsList.toArray(), contract.toArray());
        assertArrayEquals(paymentsList.toArray(), payment.toArray());
    }
    @Test
    public void getList_getAllPaymentsList_GotAllLists(){
        SystemContracts paymentContractsList = SystemContracts.create();
        paymentContractsList.addContract("number","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(100, 1, DocumentType.PaymentOrder,"number", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(200, 2, DocumentType.BankOrder,"number", "YYYYMMDD");
        paymentContractsList.addContract("number1","YYYYMMDD");
        paymentContractsList.registerPaymentDocument(300, 1, DocumentType.PaymentOrder,"number1", "YYYYMMDD");
        paymentContractsList.registerPaymentDocument(400, 2, DocumentType.BankOrder,"number1", "YYYYMMDD");
        List<Integer> paymentDocuments = new ArrayList();
        paymentDocuments.add(100);
        paymentDocuments.add(200);
        paymentDocuments.add(300);
        paymentDocuments.add(400);
        assertArrayEquals(paymentDocuments.toArray(),paymentContractsList.getAllPayments().toArray());
    }
}
