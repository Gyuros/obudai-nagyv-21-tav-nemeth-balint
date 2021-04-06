package cookbook.service;

import cookbook.domain.Identifiable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CookbookObserverBaseService<T extends Identifiable> extends CookbookBaseService<T> implements ObserverBaseService<T> {

    private List<Observable> observables;

    protected CookbookObserverBaseService(String initFile) {
        super(initFile);
        observables = new ArrayList<>();
    }

    protected void updateObservables() throws IOException {
        for (var observable : observables) {
            observable.update(this);
        }
    }

    public void add(Observable observable) {
        observables.add(observable);
    }
}
