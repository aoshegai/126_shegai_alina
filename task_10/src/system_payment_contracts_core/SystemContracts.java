package system_payment_contracts_core;

import javax.xml.crypto.Data;
import java.util.*;

public class SystemContracts {
    private HashMap<String, Contract> data;
    private SystemContracts() {
        data = new HashMap<>();
    }

    public void addContract(String number, String date) {
        StringBuilder error = new StringBuilder();
        if(number == null)
            error.append("Number can not be null\n");
        if(date == null)
            error.append("Date can not be null\n");
        if(!error.isEmpty())
            throw new IllegalArgumentException(error.toString());
        if (!data.containsKey(number)) {
            data.put(number, new Contract(date));
        } else {
            System.out.println("договор с уже существующим номером");
        }
    }

    public static SystemContracts create() {
        return new SystemContracts();
    }

    public int getContractsCount() {
        return data.size();
    }

    public void registerPaymentDocument(int sum, int documentNumber, DocumentType type, String number, String date) {
        StringBuilder error = new StringBuilder();
        if(sum<0){
            error.append("sum is positive\n");
        }
        if(documentNumber<0){
            error.append("document number is positive\n");
        }
        if(!error.isEmpty())
            throw new IllegalArgumentException(error.toString());
        data.get(number).registerPaymentDocument(sum,documentNumber,type,date);
    }

    public HashMap<String, Contract> getContracts() {
        return data;
    }

    public void deletePayment(int documentNumber, String number, String date) {
        data.get(number).getPayments().remove(documentNumber);
    }

    public HashMap<String, Integer> getAllContractsAndPayments() {
        HashMap<String, Integer> contractsAndPayments = new HashMap();
        for (Map.Entry<String, Contract> entry: data.entrySet()){
            contractsAndPayments.put(entry.getKey(), entry.getValue().getPaymentsSum());
        }
        return contractsAndPayments;
    }

    public List<Integer> getAllPayments() {
        List<Integer> payments = new ArrayList();
        for(Contract document: data.values()){
            for(PaymentDocument paymentDocument : document.getPayments().values())
                payments.add(paymentDocument.getSum());
        }
        return payments;
    }
}
