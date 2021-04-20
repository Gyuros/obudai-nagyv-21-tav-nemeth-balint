package cookbook.view.cook;

import cookbook.service.dto.CookDto;

public interface CookView {
    void printUserOptions();

    void printGuestOptions();

    void printNotAuthenticated();

    void printLogout(CookDto user);

    CookDto readUser();

    void printIncorrectCredentials();

    void printUserLoggedIn(CookDto user);
}
