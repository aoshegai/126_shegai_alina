package system_payment_contracts_core;

import java.util.HashMap;

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
}
