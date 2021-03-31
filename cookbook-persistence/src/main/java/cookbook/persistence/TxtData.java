package cookbook.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtData implements Data {

    @Override
    public String read(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();

        try {
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }

        return sb.toString();
    }

    @Override
    public void write(String filename, String value) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(value);
        }
    }
}
