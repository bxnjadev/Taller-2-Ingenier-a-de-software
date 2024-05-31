package cl.ucn.ingsoftware.taller2.taller2.util;

import java.io.IOException;
import java.util.List;

public class ReaderUtil {

    private ReaderUtil() {

    }

    public static String readAllAsString(Reader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}
