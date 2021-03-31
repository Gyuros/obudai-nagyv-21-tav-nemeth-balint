package cookbook.service.auth;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.service.Initializable;

public interface AuthService extends Initializable {

    void login(String username);

    void logout();

    boolean isLoggedIn();

    Cook getCurrentUser();

    boolean authenticate(User user);
}
