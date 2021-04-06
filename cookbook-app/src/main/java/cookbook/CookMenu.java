package cookbook;

import cookbook.domain.User;
import cookbook.service.cook.CookService;
import cookbook.view.GeneralView;
import cookbook.view.cook.CookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CookMenu {

    @Autowired
    private CookView cookView;

    @Autowired
    private CookService cookService;

    @Autowired
    private GeneralView generalView;

    @Autowired
    private RecipeMenu recipeMenu;

    public void init() {
        try {
            cookService.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMainMenu() {
        String input = "";
        while (!input.equals("q")) {
            if(cookService.isLoggedIn()) {
                cookView.printUserOptions();
            } else {
                cookView.printGuestOptions();
            }

            input = generalView.getInput().toLowerCase();
            processMainMenuInput(input);
        }
    }

    private void processMainMenuInput(String input) {
        switch (input){
            case "1": login(); break;
            case "2": recipeMenu.listRecipes(); break;
            default: generalView.printEnd();
        }
    }

    private void login() {
        User user = cookView.readUser();
        if(cookService.authenticate(user)){
            cookView.printUserLoggedIn(cookService.getCurrentUser());
        }else{
            cookView.printIncorrectCredentials();
        }

        processPostLoginInput();
    }

    private void processPostLoginInput() {

    }
}
