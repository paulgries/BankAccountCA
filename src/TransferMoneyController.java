public class TransferMoneyController {
    private TransferMoneyInputBoundary interactor;

    public TransferMoneyController(TransferMoneyInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void transferMoney(String sourceAccountId, String destinationAccountId, Money amount) {
        TransferMoneyInputData inputData = new TransferMoneyInputData(sourceAccountId, destinationAccountId, amount);
        interactor.execute(inputData);
    }
}
