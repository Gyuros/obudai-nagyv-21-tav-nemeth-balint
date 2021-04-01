package cookbook.service;

import cookbook.domain.Identifiable;
import cookbook.service.BaseService;
import cookbook.service.Observable;

public interface ObserverBaseService<T extends Identifiable> extends BaseService<T> {
    void add(Observable observable);
}
