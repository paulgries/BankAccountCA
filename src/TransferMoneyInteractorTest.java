import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransferMoneyInteractorTest {
    private InMemoryBankAccountRepository repository;
    private TransferMoneyInteractor interactor;
    private TestTransferMoneyOutputBoundary outputBoundary;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryBankAccountRepository();
        outputBoundary = new TestTransferMoneyOutputBoundary();
        interactor = new TransferMoneyInteractor(repository, outputBoundary);
    }

    @Test
    public void testSuccessfulTransfer() {
        TransferMoneyInputData inputData = new TransferMoneyInputData("123", "456", new Money(50, 0));
        interactor.execute(inputData);

        assertEquals("Success", outputBoundary.getStatus());
        assertEquals(new Money(50, 0), outputBoundary.getTransferredAmount());
        assertEquals(new Money(50, 0), repository.findAccountById("123").getBalance());
        assertEquals(new Money(250, 50), repository.findAccountById("456").getBalance());
    }

    @Test
    public void testInsufficientFunds() {
        TransferMoneyInputData inputData = new TransferMoneyInputData("123", "456", new Money(150, 0));
        interactor.execute(inputData);

        assertEquals("Fail", outputBoundary.getStatus());
        assertEquals("Insufficient funds", outputBoundary.getErrorMessage());
    }

    // Helper class for testing
    private class TestTransferMoneyOutputBoundary implements TransferMoneyOutputBoundary {
        private String status;
        private Money transferredAmount;
        private String errorMessage;

        @Override
        public void prepareSuccessView(TransferMoneyOutputData outputData) {
            this.status = "Success";
            this.transferredAmount = outputData.getTransferredAmount();
        }

        @Override
        public void prepareFailView(TransferMoneyOutputData outputData) {
            this.status = "Fail";
            this.errorMessage = outputData.getErrorMessage();
        }

        public String getStatus() {
            return status;
        }

        public Money getTransferredAmount() {
            return transferredAmount;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
