public class AppFactory {
    public static TransferMoneyView createTransferMoneyView() {
        // Instantiate DAOs
        InMemoryBankAccountRepository repository = new InMemoryBankAccountRepository();

        // Instantiate ViewModel
        TransferMoneyViewModel viewModel = new TransferMoneyViewModel();

        // Instantiate Presenter and inject ViewModel
        TransferMoneyPresenter presenter = new TransferMoneyPresenter(viewModel);

        // Instantiate Interactor and inject DAOs and Presenter
        TransferMoneyInteractor interactor = new TransferMoneyInteractor(repository, presenter);

        // Instantiate Controller and inject Interactor
        TransferMoneyController controller = new TransferMoneyController(interactor);

        // Instantiate View and inject ViewModel and Controller
        TransferMoneyView view = new TransferMoneyView(controller, viewModel);

        // Set the view in the presenter
        presenter.setView(view);

        return view;
    }
}
