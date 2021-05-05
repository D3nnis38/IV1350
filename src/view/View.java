package view;
import controller.Controller;

/**
 * The class which the user should interact with
 *
 * @author dennishadzialic
 */
public class View {
    private final Controller controller;

    /**
     * Constructor for class View
     *
     * @param controller a reference to the controller created in Main.java
     */
    public View(Controller controller) {
        this.controller = controller;
    }
}
