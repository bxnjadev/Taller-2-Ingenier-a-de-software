package cl.ucn.ingsoftware.taller2.taller2.util;

import java.io.IOException;

/**
 *
 */

public interface Reader extends AutoCloseable {

    String readLine() throws IOException;

    void close() throws IOException;

}
