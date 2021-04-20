package cookbook.service.cook;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.persistence.repository.CookRepository;
import cookbook.service.CookbookObserverBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CookbookCookService extends CookbookObserverBaseService<Cook> implements CookService {

    @Autowired
    private CookRepository cookRepository;

    private Cook currentUser;

    public CookbookCookService() {
        super("cooks.txt");
    }

    @Override
    public void logout() throws IOException {
        updateObservables();
        currentUser = null;
    }

    @Override
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    @Override
    public Cook getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean authenticate(User user) {
        Cook cook = models.stream()
                .filter(c -> c.equals(user))
                .findFirst()
                .orElse(null);

        if(cook != null)
            currentUser = cook;

        return cook != null;
    }
}
