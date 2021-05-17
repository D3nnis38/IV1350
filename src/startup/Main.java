package startup;

import controller.Controller;
import controller.OperationException;
import dbHandler.DBHandler;
import dbHandler.InvalidIdentifierException;
import view.View;
/**
 * The Main-class containing the main-method which creates insctances of View, Controller, dbHandler, etc...
 *
 * @author dennishadzialic
 */
public class Main {
    /**
     * The main function of the program
     *
     * @param args no terminal arguments/parameters
     */
    public static void main(String[] args) throws InvalidIdentifierException, OperationException {
        DBHandler handler = new DBHandler();
        Controller contr = new Controller(handler);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
