import java.util.Map;

public class TransferMoneyViewModel {
    private boolean success;
    private Map<String, Money> accountBalances;
    private Money transferredAmount;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Money> getAccountBalances() {
        return accountBalances;
    }

    public void setAccountBalances(Map<String, Money> accountBalances) {
        this.accountBalances = accountBalances;
    }

    public Money getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(Money transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
