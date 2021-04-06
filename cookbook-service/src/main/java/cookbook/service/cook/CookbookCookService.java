package cookbook.service.cook;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.exception.IncorrectCredentialsException;
import cookbook.service.CookbookObserverBaseService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CookbookCookService extends CookbookObserverBaseService<Cook> implements CookService {

    private Cook currentUser;

    public CookbookCookService() {
        super("cooks.txt");
    }

    @Override
    public void login(String username, String password) throws IncorrectCredentialsException {
        currentUser = models.stream()
                .filter(c -> c.getUsername().equals(username))
                .filter(c -> c.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (currentUser == null)
            throw new IncorrectCredentialsException("User doesn't exist.");
    }

    @Override
    public void logout() throws IOException {
        updateObservables();
        currentUser = null;
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public Cook getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean authenticate(User user) {
        return false;
    }
}
