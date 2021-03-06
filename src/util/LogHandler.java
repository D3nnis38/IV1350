package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Superclass for logs
 *
 * @author dennishadzialic
 */
public interface LogHandler {
    LocalDateTime timeRightNow = LocalDateTime.now();

    /**
     * @return the string that has been logged
     */
    void log(Exception exception);

    /**
     * @return the current date and time
     */
    default String getDateAndTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeRightNow.format(dateFormatter);
    }
}
