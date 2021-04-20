package cookbook.service.cook;

import cookbook.service.dto.CookDto;

import java.io.IOException;

public interface CookService extends ObserverBaseService {

    void logout() throws IOException;

    boolean isLoggedIn();

    CookDto getCurrentUser();

    boolean authenticate(CookDto user);
}
