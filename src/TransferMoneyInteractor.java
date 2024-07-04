import java.util.HashMap;
import java.util.Map;

public class TransferMoneyInteractor implements TransferMoneyInputBoundary {
    private BankAccountRepository repository;
    private TransferMoneyOutputBoundary outputBoundary;

    public TransferMoneyInteractor(BankAccountRepository repository, TransferMoneyOutputBoundary outputBoundary) {
        this.repository = repository;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(TransferMoneyInputData inputData) {
        // Get BankAccount objects from the DAO
        BankAccount sourceAccount = repository.findAccountById(inputData.getSourceAccountId());
        BankAccount destinationAccount = repository.findAccountById(inputData.getDestinationAccountId());
        Money transferAmount = inputData.getAmount();

        // Check for non-existent accounts
        if (sourceAccount == null) {
            TransferMoneyOutputData outputData = new TransferMoneyOutputData("Source account not found");
            outputBoundary.prepareFailView(outputData);
            return;
        }

        if (destinationAccount == null) {
            TransferMoneyOutputData outputData = new TransferMoneyOutputData("Destination account not found");
            outputBoundary.prepareFailView(outputData);
            return;
        }

        // Check for insufficient funds
        if (sourceAccount.getBalance().toCents() < transferAmount.toCents()) {
            TransferMoneyOutputData outputData = new TransferMoneyOutputData("Insufficient funds");
            outputBoundary.prepareFailView(outputData);
            return;
        }

        // Subtract the money from one account and add it to the other
        sourceAccount.withdraw(transferAmount);
        destinationAccount.deposit(transferAmount);

        // Create a map of the updated balances
        Map<String, Money> accountBalances = new HashMap<>();
        accountBalances.put(sourceAccount.getAccountNumber(), sourceAccount.getBalance());
        accountBalances.put(destinationAccount.getAccountNumber(), destinationAccount.getBalance());

        // Create an OutputData object
        TransferMoneyOutputData outputData = new TransferMoneyOutputData(accountBalances, transferAmount);

        // Call the Presenter through the OutputBoundary
        outputBoundary.prepareSuccessView(outputData);
    }

}
