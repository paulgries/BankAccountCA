import java.util.Map;

public class TransferMoneyPresenter implements TransferMoneyOutputBoundary {
    private TransferMoneyView view;
    private TransferMoneyViewModel viewModel;

    public TransferMoneyPresenter(TransferMoneyViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setView(TransferMoneyView view) {
        this.view = view;
    }

    @Override
    public void prepareSuccessView(TransferMoneyOutputData outputData) {
        viewModel.setSuccess(true);
        viewModel.setAccountBalances(outputData.getAccountBalances());
        viewModel.setTransferredAmount(outputData.getTransferredAmount());
        view.displayResult(viewModel);
    }

    @Override
    public void prepareFailView(TransferMoneyOutputData outputData) {
        viewModel.setSuccess(false);
        viewModel.setErrorMessage(outputData.getErrorMessage());
        view.displayResult(viewModel);
    }
}
