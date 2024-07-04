import java.util.Map;

public class TransferMoneyOutputData {
    private Map<String, Money> accountBalances;
    private Money transferredAmount;
    private String errorMessage;

    // Constructor for success case
    public TransferMoneyOutputData(Map<String, Money> accountBalances, Money transferredAmount) {
        this.accountBalances = accountBalances;
        this.transferredAmount = transferredAmount;
        this.errorMessage = null;
    }

    // Constructor for failure case
    public TransferMoneyOutputData(String errorMessage) {
        this.accountBalances = null;
        this.transferredAmount = null;
        this.errorMessage = errorMessage;
    }

    // Getters
    public Map<String, Money> getAccountBalances() {
        return accountBalances;
    }

    public Money getTransferredAmount() {
        return transferredAmount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
