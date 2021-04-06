package cookbook;

import cookbook.domain.Recipe;
import cookbook.service.recipe.RecipeService;
import cookbook.view.GeneralView;
import cookbook.view.recipe.RecipeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class RecipeMenu {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeView recipeView;

    @Autowired
    private GeneralView generalView;

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

            List<Recipe> recipes = recipeService.getRecipes();
            recipeView.printRecipes(recipes);
            input = generalView.getInput();

            try {
                printRecipe(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                // go back or redraw recipes menu
            }
        }
    }

    private void printRecipe(int index) {

    }
}
