package cookbook.persistence;

import java.io.IOException;

public interface Data {

    String read(String filename) throws IOException;

    void write(String filename, String value) throws IOException;
}
