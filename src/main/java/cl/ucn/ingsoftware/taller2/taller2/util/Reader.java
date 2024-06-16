package cl.ucn.ingsoftware.taller2.taller2.util;

import java.io.IOException;

/**
 * This interface act as reader file
 */

public interface Reader extends AutoCloseable {

    /**
     * Read the next line
     * @return the next line
     * @throws IOException throw exception if file no exists
     */

    String readLine() throws IOException;

    /**
     * Close file
     * @throws IOException throw exception if file no exists
     */

    void close() throws IOException;

}
