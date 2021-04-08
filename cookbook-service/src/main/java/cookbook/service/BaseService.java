package cookbook.service;

import cookbook.domain.Identifiable;
import cookbook.exception.ModelNotFoundException;

import java.io.IOException;

public interface BaseService<T extends Identifiable> {

    void init() throws IOException;

    T findById(long id) throws ModelNotFoundException;
}
