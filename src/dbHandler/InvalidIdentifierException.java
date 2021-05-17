package dbHandler;

public class InvalidIdentifierException extends Exception {
    /**
     * Creates an instance of <code>InvalidItemException</code> with a given message.
     *
     * @param msg why the exception was thrown.
     */
    public InvalidIdentifierException(String msg) {
        super(msg);
    }
}
