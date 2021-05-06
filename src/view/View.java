package view;

import controller.Controller;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller
 *
 * @author dennishadzialic
 */
public class View {
    private final Controller contr;

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
    public void runFakeExecution() {
        contr.startSale();
        System.out.println("A new sale has been started.");
        System.out.println("Entering itemID: 123456, quantity: 1.");
        contr.enterItem("123456", 1);
        System.out.println("Entering itemID: 123457, quantity: 3.");
        contr.enterItem("123457", 3);
        System.out.println("Entering itemID: 123460, quantity: 5.");
        contr.enterItem("123460", 5);


    }

}
