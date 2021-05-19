package view;

import controller.Controller;
import controller.OperationException;
import dbHandler.InvalidIdentifierException;
import util.ConsoleLogger;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller
 *
 * @author dennishadzialic
 */
public class View {
    private final Controller contr;
    private final ErrorMessageHandler errorMsgHandler = ErrorMessageHandler.getErrorMessage();
    private final ConsoleLogger consoleLogger = ConsoleLogger.getConsoleLogger();


    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers
     *
     * @param contr The controller to use for all calls to other layers
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller
     */
    public void runFakeExecution() throws InvalidIdentifierException, OperationException {
        startSale();
//        enterItem();
        enterItemException();
        endSale();
    }

    private void enterItemException() throws OperationException {
        try {
            System.out.println("Entering itemID: 123456, quantity: 1.");
            System.out.println(contr.enterItem("123456", 1));

            System.out.println("Entering itemID: 123457, quantity: 3.");
            System.out.println(contr.enterItem("123457", 3));

            System.out.println("Entering itemID: 1234600, quantity: 5.");
            System.out.println(contr.enterItem("1234600", 5));
        } catch (InvalidIdentifierException exception) {
            errorMsgHandler.displayErrorMessage(exception.getMessage());
        }
    }

    private void startSale() {
        contr.startSale();
        System.out.println("A new sale has been started.");
    }

    private void enterItem() throws InvalidIdentifierException, OperationException {
        System.out.println("Entering itemID: 123456, quantity: 1.");
        System.out.println(contr.enterItem("123456", 1));

        System.out.println("Entering itemID: 123457, quantity: 3.");
        System.out.println(contr.enterItem("123457", 3));

        System.out.println("Entering itemID: 123460, quantity: 5.");
        System.out.println(contr.enterItem("123460", 5));
    }

    private void endSale() {
        System.out.println("Cashier ends sale.");
        try {
            double totalAmount = contr.getTotal();
            System.out.println("Total is: " + totalAmount + " SEK.");
            System.out.println("Customer pays: 1800.0 SEK");
            contr.endSale(1800);
        } catch (IllegalStateException exception) {
            errorMsgHandler.displayErrorMessage("Sale have not started yet");
        }

    }

}
