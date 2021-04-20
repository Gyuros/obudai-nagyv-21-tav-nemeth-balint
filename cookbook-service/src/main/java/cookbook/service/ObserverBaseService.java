package cookbook.service;

import cookbook.domain.Identifiable;

public interface ObserverBaseService<T extends Identifiable> extends BaseService<T> {
    void add(Observable observable);
}
