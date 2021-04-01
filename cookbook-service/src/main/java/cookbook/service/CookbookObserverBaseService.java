package cookbook.service;

import cookbook.domain.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class CookbookObserverBaseService<T extends Identifiable> extends CookbookBaseService<T> implements ObserverBaseService<T> {

    private List<Observable> observables;

    protected CookbookObserverBaseService(String initFile) {
        super(initFile);
        observables = new ArrayList<>();
    }

    protected void updateObservables() {
        observables.forEach(o -> o.update(this));
    }

    public void add(Observable observable) {
        observables.add(observable);
    }
}
