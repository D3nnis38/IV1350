package dbHandler;

/**
 * Throws if host can't connect to databse (Hardcoded to throw if itemidentifier is empty === "")
 *
 * @author dennishadzialic
 */
public class ConnectivityException extends RuntimeException {

    /**
     * Creates an instance of <code>ConnectivityException</code> with a given message.
     *
     * @param msg Information about the reason why the exception is thrown.
     */
    public ConnectivityException(String msg) {
        super(msg);
    }
}
