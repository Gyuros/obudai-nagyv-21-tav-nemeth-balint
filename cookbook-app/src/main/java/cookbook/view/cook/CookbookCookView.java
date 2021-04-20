package cookbook.view.cook;

import cookbook.service.dto.CookDto;
import cookbook.view.BaseView;
import cookbook.view.GeneralView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookbookCookView extends BaseView implements CookView {

    @Autowired
    private GeneralView generalView;

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
    public void printLogout(CookDto user) {
        print("-- " + user.getUsername() + " user logged out --");
    }

    @Override
    public CookDto readUser() {
        println();
        print("Give me your username:");
        String username = generalView.getInput();
        print("Give me your password:");
        String password = generalView.getInput();
        return new CookDto(username, password);
    }

    @Override
    public void printIncorrectCredentials() {
        print("Incorrect credentials.");
    }

    @Override
    public void printUserLoggedIn(CookDto user) {
        print("-- " + user.getUsername() + " logged in --");
    }
}
