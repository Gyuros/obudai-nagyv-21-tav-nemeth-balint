package cookbook.service.cook;

import cookbook.service.ObserverBaseService;
import cookbook.service.dto.CookResult;

import java.io.IOException;

public interface CookService extends ObserverBaseService {

    void logout() throws IOException;

    boolean isLoggedIn();

    CookResult getCurrentUser();

    boolean authenticate(CookResult user);
}
