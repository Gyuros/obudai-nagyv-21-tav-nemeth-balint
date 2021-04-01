package cookbook.service.cook;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.service.ObserverBaseService;

public interface CookService extends ObserverBaseService<Cook> {

    void login(String username);

    void logout();

    boolean isLoggedIn();

    Cook getCurrentUser();

    boolean authenticate(User user);
}
