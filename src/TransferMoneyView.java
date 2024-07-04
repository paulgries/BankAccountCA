import java.util.Scanner;

public class TransferMoneyView {
    private TransferMoneyController controller;
    private TransferMoneyViewModel viewModel;
    private Scanner scanner;

    public TransferMoneyView(TransferMoneyController controller, TransferMoneyViewModel viewModel) {
        this.controller = controller;
        this.viewModel = viewModel;
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println("Welcome to the Bank Transfer App");
        System.out.print("Enter source account number: ");
        String sourceAccountId = scanner.nextLine();
        System.out.print("Enter destination account number: ");
        String destinationAccountId = scanner.nextLine();
        System.out.print("Enter amount to transfer (dollars): ");
        int dollars = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount to transfer (cents): ");
        int cents = Integer.parseInt(scanner.nextLine());

        controller.transferMoney(sourceAccountId, destinationAccountId, new Money(dollars, cents));
    }

    public void displayResult(TransferMoneyViewModel viewModel) {
        if (viewModel.isSuccess()) {
            System.out.println("Transfer successful!");
            viewModel.getAccountBalances().forEach((accountId, balance) ->
                    System.out.println("Account " + accountId + " new balance: " + balance.getDollars() + " dollars and " + balance.getCents() + " cents"));
        } else {
            System.out.println("Transfer failed: " + viewModel.getErrorMessage());
        }
    }
}
