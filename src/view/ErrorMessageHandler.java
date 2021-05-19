package view;

import java.time.LocalDateTime;

/**
 * Displays error-messages to the User
 *
 * @author dennishadzialic
 */
public class ErrorMessageHandler {
    private static final ErrorMessageHandler ERROR_MESSAGE = new ErrorMessageHandler();
    LocalDateTime timeRightNow = LocalDateTime.now();

    public ErrorMessageHandler() {
    }

    /**
     * @return the error message
     */
    public static ErrorMessageHandler getErrorMessage() {
        return ERROR_MESSAGE;
    }

    /**
     * @return the date and time of today
     */
    public String getDateAndTime() {
        return timeRightNow.toString();
    }

    /**
     * Displays the specified error message.
     *
     * @param msg The error message to display.
     */
    void displayErrorMessage(String msg) {
        String error = getDateAndTime() +
                "\n" +
                " ERROR: " +
                "\n" +
                msg +
                "\n";
        System.out.println(error);
    }
}
