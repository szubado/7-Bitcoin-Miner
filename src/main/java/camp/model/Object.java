package camp.model;

public class Object implements IObject {
private double amount;
private String lastTransaction;
private long nonce;
    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.amount)
                .append(this.lastTransaction)
                .append(this.nonce)
                .toString();
    }

    public Object(double amount) {
        this.amount = amount;
    }

    public Object(double amount, String lastTransaction) {
        this.amount = amount;
        this.lastTransaction = lastTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }
}
