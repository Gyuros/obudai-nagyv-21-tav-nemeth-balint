package cookbook.persistence;

public interface Data {

    String read(String filename);

    void write(String filename, String value);
}
