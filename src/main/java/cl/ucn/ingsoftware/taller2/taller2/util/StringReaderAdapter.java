package cl.ucn.ingsoftware.taller2.taller2.util;

import cl.ucn.ingsoftware.taller2.taller2.HelloApplication;

import java.io.IOException;
import java.io.InputStream;

public class StringReaderAdapter implements Reader {

    private final Reader reader;

    public StringReaderAdapter(String fileName) {
        InputStream inputStream = HelloApplication
                .class.getResourceAsStream(
                        fileName
        );

        reader = new DefaultReader(inputStream);
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
