public interface TransferMoneyOutputBoundary {
    void prepareSuccessView(TransferMoneyOutputData outputData);
    void prepareFailView(TransferMoneyOutputData outputData);
}
