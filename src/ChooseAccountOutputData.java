public class ChooseAccountOutputData {
    private String accountId;
    private String ownerName;
    private Money balance;

    public ChooseAccountOutputData(String accountId, String ownerName, Money balance) {
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Money getBalance() {
        return balance;
    }
}
