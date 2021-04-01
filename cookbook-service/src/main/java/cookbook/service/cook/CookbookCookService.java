package cookbook.service.cook;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.service.CookbookObserverBaseService;
import org.springframework.stereotype.Component;

@Component
public class CookbookCookService extends CookbookObserverBaseService<Cook> implements CookService {

    public CookbookCookService() {
        super("cooks.txt");
    }

    @Override
    public void login(String username) {

    }

    @Override
    public void logout() {
        updateObservables();
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public Cook getCurrentUser() {
        return null;
    }

    @Override
    public boolean authenticate(User user) {
        return false;
    }
}
