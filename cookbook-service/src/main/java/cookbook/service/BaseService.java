package cookbook.service;

import cookbook.exception.ModelNotFoundException;

import java.io.IOException;

public interface BaseService<T extends Identifiable> {

    void init() throws IOException;

    T findById(long id) throws ModelNotFoundException;
}
