package cookbook.service.auth;

import cookbook.domain.Cook;
import cookbook.domain.User;

public interface AuthService {

    void login(String username);

    void logout();

    boolean isLoggedIn();

    Cook getCurrentUser();

    boolean authenticate(User user);
}
