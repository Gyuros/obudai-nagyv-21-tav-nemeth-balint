package cookbook.service.cook;

import cookbook.service.dto.CookDto;

import java.io.IOException;

public interface CookService {

    void logout() throws IOException;

    boolean isLoggedIn();

    CookDto getCurrentUser();

    boolean authenticate(CookDto user);
}
