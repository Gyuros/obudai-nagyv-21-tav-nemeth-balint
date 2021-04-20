package cookbook.view.cook;

public interface CookView {
    void printUserOptions();

    void printGuestOptions();

    void printNotAuthenticated();

    void printLogout(User user);

    User readUser();

    void printIncorrectCredentials();

    void printUserLoggedIn(User user);
}
