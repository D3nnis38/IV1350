package controller;

/**
 * Throws if the controller fails to register new product
 */
public class OperationException extends Exception {
    /**
     * Creates an instance of <code>ConnectivityException</code> with a given message.
     *
     * @param msg Information about the reason why the exception is thrown.
     */
    public OperationException(String msg, Exception cause) {
        super(msg);
    }
}
