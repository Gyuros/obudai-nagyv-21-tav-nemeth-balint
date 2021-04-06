package cookbook.service;

import java.io.IOException;

public interface Observable {

    void update(Object observer) throws IOException;
}
