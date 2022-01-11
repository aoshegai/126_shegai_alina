package system_payment_contracts_tests;

import org.junit.*;
import system_payment_contracts_core.*;

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
}
