public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private Money balance;

    // Constructor
    public BankAccount(String accountNumber, String ownerName, Money initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Money getBalance() {
        return balance;
    }

    // Methods to deposit and withdraw money
    public void deposit(Money amount) {
        if (amount != null && (amount.getDollars() > 0 || amount.getCents() > 0)) {
            this.balance = this.balance.add(amount);
        }
    }

    public void withdraw(Money amount) {
        if (amount != null && (amount.getDollars() > 0 || amount.getCents() > 0)) {
            this.balance = this.balance.subtract(amount);
        }
    }
}
