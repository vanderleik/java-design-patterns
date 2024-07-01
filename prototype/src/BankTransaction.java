package src;

public class BankTransaction implements TransactionPrototype {

    private String type;
    private double amount;
    private String accountNumber;
    private String details;

    public BankTransaction(String type, double amount, String accountNumber, String details) {
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.details = details;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public BankTransaction clone() {
        try {
            return (BankTransaction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", accountNumber='" + accountNumber + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
