package cookbook;

import cookbook.domain.Recipe;
import cookbook.service.cook.CookService;
import cookbook.service.recipe.RecipeService;
import cookbook.view.GeneralView;
import cookbook.view.recipe.RecipeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RecipeMenu {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeView recipeView;

    @Autowired
    private GeneralView generalView;

    @Autowired
    private CommentMenu commentMenu;

    @Autowired
    private CookService cookService;

    public void init() {
        try {
            recipeService.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listRecipes() {
        String input = "";
        while (!input.equals("q")) {

            recipeView.printRecipes(recipeService.getRecipes());
            input = generalView.getInput();

            try {
                printRecipe(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                // go back or redraw recipes menu
            }
        }
    }

    private void printRecipe(int index) {
        try {
            Recipe recipe = recipeService.getRecipes().get(index);
            recipeView.printRecipe(recipe);

            String input = "";
            while (!input.equals("q")) {
                if(cookService.isLoggedIn()){
                    recipeView.printUserRecipeOptions();
                }else{
                    recipeView.printGuestRecipeOptions();
                }

                input = generalView.getInput().toLowerCase();
                commentMenu.processRecipeMenuInput(recipe, input);
            }
        } catch (IndexOutOfBoundsException e) {
            // redraw recipes menu
        }
    }
}
