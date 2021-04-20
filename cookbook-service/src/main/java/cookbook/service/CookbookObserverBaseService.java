package cookbook.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CookbookObserverBaseService implements ObserverBaseService {

    private final List<Observable> observables;

    protected CookbookObserverBaseService() {
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
