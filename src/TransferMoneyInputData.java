public class TransferMoneyInputData {
    private String sourceAccountId;
    private String destinationAccountId;
    private Money amount;

    // Constructor
    public TransferMoneyInputData(String sourceAccountId, String destinationAccountId, Money amount) {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
    }

    // Getters
    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public Money getAmount() {
        return amount;
    }
}
