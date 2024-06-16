package cl.ucn.ingsoftware.taller2.taller2.util;

import java.io.*;

/**
 * Main reader file, this way for read is
 * reading line per line
 */

public class DefaultReader implements Reader {

    private final BufferedReader bufferedReader;

    public DefaultReader(InputStream inputStream) {
        bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
        );
    }

    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }



    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }

}
