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
        while (!input.equals("q") || cookService.isLoggedIn()) {
            if(cookService.isLoggedIn()) {
                cookView.printUserOptions();
                input = generalView.getInput().toLowerCase();
                processPostLoginInput(input);
            } else {
                cookView.printGuestOptions();
                input = generalView.getInput().toLowerCase();
                processMainMenuInput(input);
            }
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
    }

    private void processPostLoginInput(String input) {
        switch (input){
            case "1": recipeMenu.newRecipe(); break;
            case "2": recipeMenu.listRecipes(); break;
            case "3": recipeMenu.deleteRecipe(); break;
            case "4": logout();
        }
    }

    private void logout() {
        try {
            cookService.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
