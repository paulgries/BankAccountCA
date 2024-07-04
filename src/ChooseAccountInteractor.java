public class ChooseAccountInteractor implements ChooseAccountInputBoundary {
    private BankAccountRepository repository;
    private ChooseAccountOutputBoundary outputBoundary;

    public ChooseAccountInteractor(BankAccountRepository repository, ChooseAccountOutputBoundary outputBoundary) {
        this.repository = repository;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ChooseAccountOutputData chooseAccount(ChooseAccountInputData inputData) {
        BankAccount account = repository.findAccountById(inputData.getAccountId());
        ChooseAccountOutputData outputData = new ChooseAccountOutputData(
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance()
        );
        outputBoundary.present(outputData);
        return outputData;
    }
}
