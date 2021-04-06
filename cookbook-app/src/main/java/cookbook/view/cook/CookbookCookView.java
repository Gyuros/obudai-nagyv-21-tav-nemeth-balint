package cookbook.view.cook;

import cookbook.domain.User;
import cookbook.view.BaseView;
import org.springframework.stereotype.Component;

@Component
public class CookbookCookView extends BaseView implements CookView {

    @Override
    public void printUserOptions() {
        println();
        print(
                "1: Create new recipe.",
                "2: List existing recipes.",
                "3: Delete recipe.",
                "4: Log out.");
    }

    @Override
    public void printGuestOptions() {
        println();
        print(
                "1: Log in.",
                "2: Browse existing recipes.",
                "Q: Exit the application");
    }

    @Override
    public void printNotAuthenticated() {
        print("User not authenticated");
    }

    @Override
    public void printLogout(User user) {
        print("-- " + user.getUsername() + " user logged out --");
    }

    @Override
    public User readUser() {
        return null;
    }

    @Override
    public void printIncorrectCredentials() {

    }
}
