package system_payment_contracts_core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Contract {
    private String date;
    private HashMap<Integer, PaymentDocument> paymentDocuments;

    public Contract(String date){
        this.date = date;
        paymentDocuments = new HashMap<>();
    }

    public void registerPaymentDocument(int sum, int documentNumber, DocumentType type, String date){
        paymentDocuments.put(documentNumber,new PaymentDocument(sum,type,date));
    }

    public int getDocumentsCount() {
        return paymentDocuments.size();
    }

    public ArrayList<Integer> getPaymentsList() {
        ArrayList<Integer> payments = new ArrayList();
        for(PaymentDocument paymentDocument : paymentDocuments.values()){
            payments.add(paymentDocument.getSum());
        }
        return payments;
    }

    public int getPaymentsSum() {
        int sum=0;
        for(PaymentDocument document : paymentDocuments.values()){
            sum += document.getSum();
        }
        return sum;
    }
}
