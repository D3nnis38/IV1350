package startup;

import controller.Controller;
import dbHandler.DBHandler;
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
    public static void main(String[] args) {
        DBHandler handler = new DBHandler();
        Controller contr = new Controller(handler);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
