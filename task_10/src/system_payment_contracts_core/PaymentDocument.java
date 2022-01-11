package system_payment_contracts_core;

public class PaymentDocument {
    private int sum;
    private String date;
    private DocumentType type;

    public PaymentDocument(int sum, DocumentType type, String date) {
        this.sum = sum;
        this.type=type;
        this.date = date;
    }
}
