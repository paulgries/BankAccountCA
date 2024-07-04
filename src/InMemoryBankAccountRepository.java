import java.util.HashMap;
import java.util.Map;

public class InMemoryBankAccountRepository implements BankAccountRepository {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public InMemoryBankAccountRepository() {
        // Pre-populate with some dummy data
        accounts.put("123", new BankAccount("123", "Alice", new Money(100, 0)));
        accounts.put("456", new BankAccount("456", "Bob", new Money(200, 50)));
        accounts.put("789", new BankAccount("789", "Charlie", new Money(300, 75)));
    }

    @Override
    public BankAccount findAccountById(String accountId) {
        return accounts.get(accountId);
    }
}
