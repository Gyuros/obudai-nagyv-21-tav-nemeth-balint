package cookbook.service.cook;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.exception.IncorrectCredentialsException;
import cookbook.service.ObserverBaseService;

import java.io.IOException;

public interface CookService extends ObserverBaseService<Cook> {

    void login(String username, String password) throws IncorrectCredentialsException;

    void logout() throws IOException;

    boolean isLoggedIn();

    Cook getCurrentUser();

    boolean authenticate(User user);
}
