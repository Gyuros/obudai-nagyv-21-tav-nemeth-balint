package cookbook.view.cook;

import cookbook.domain.User;

public interface CookView {
    void printUserOptions();

    void printGuestOptions();

    void printNotAuthenticated();

    void printLogout();

    User readUser();

    void printIncorrectCredentials();
}
