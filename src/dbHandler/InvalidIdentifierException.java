package dbHandler;

/**
 * An exception when there isn't a match when seartch for an item
 *
 * @author dennishadzialic
 */
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
