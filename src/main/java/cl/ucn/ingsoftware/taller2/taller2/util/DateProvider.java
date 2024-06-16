package cl.ucn.ingsoftware.taller2.taller2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Calculate actual dates using any format specified
 */

public class DateProvider {

    private final SimpleDateFormat simpleDateFormat;

    public DateProvider(String format) {
        simpleDateFormat = new SimpleDateFormat(format);
    }

    /**
     * Get actual date with a format establish
     * @return the date
     */

    public String provide() {
        Date actualDate = new Date();
        return simpleDateFormat.
                format(actualDate);
    }

    /**
     * gets a date with an extra time in a format establish
     * @param time the time in seconds
     * @return the date  as String
     */

    public String provide(long time) {
        Date nextDate = new Date(System.currentTimeMillis() + time);
        return simpleDateFormat.format(
                nextDate
        );
    }

    public static DateProvider format(String format) {
        return new DateProvider(format);
    }

}
