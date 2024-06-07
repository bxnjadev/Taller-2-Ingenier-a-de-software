package cl.ucn.ingsoftware.taller2.taller2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProvider {

    private final SimpleDateFormat simpleDateFormat;

    public DateProvider(String format) {
        simpleDateFormat = new SimpleDateFormat(format);
    }

    public String provide() {
        Date actualDate = new Date();
        return simpleDateFormat.
                format(actualDate);
    }

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
