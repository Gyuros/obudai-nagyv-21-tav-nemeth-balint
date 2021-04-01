package cookbook.service;

import cookbook.domain.Identifiable;

import java.io.IOException;

public interface BaseService<T extends Identifiable> {

    void init() throws IOException;

    T findById(long id);
}
