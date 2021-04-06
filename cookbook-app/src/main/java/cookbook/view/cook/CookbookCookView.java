package cookbook.view.cook;

import cookbook.domain.User;
import cookbook.view.BaseView;
import org.springframework.stereotype.Component;

@Component
public class CookbookCookView extends BaseView implements CookView {

    @Override
    public void printUserOptions() {
        print(
                "1: Create new recipe.",
                "2: List existing recipes.",
                "3: Delete recipe.",
                "4: Log out.");
    }

    @Override
    public void printGuestOptions() {

    }

    @Override
    public void printNotAuthenticated() {

    }

    @Override
    public void printLogout() {

    }

    @Override
    public User readUser() {
        return null;
    }

    @Override
    public void printIncorrectCredentials() {

    }
}
