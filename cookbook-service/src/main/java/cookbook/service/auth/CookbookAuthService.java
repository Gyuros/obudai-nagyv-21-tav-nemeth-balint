package cookbook.service.auth;

import cookbook.domain.Cook;
import cookbook.domain.User;
import cookbook.persistence.Data;
import cookbook.util.CookDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CookbookAuthService implements AuthService {

    private static final String INIT_FILE = "cooks.txt";
    private List<Cook> cooks;

    @Autowired
    private Data data;

    @Autowired
    private CookDataParser cookDataParser;

    @Override
    public void init() throws IOException {
        String initData = data.read(INIT_FILE);
        cooks = cookDataParser.parse(initData);
    }

    @Override
    public void login(String username) {

    }

    @Override
    public void logout() {

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

    @Override
    public Cook findCookById(long id) {
        return cooks.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
