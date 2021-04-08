package cookbook;

import cookbook.domain.Recipe;
import cookbook.exception.ModelNotFoundException;
import cookbook.service.comment.CommentService;
import cookbook.service.cook.CookService;
import cookbook.service.recipe.RecipeService;
import cookbook.view.GeneralView;
import cookbook.view.recipe.RecipeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.CredentialNotFoundException;

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

    @Autowired
    private CommentService commentService;

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

    public void newRecipe() {
        Recipe recipe = recipeView.readRecipe(cookService.getCurrentUser());
        recipeService.addRecipe(recipe);
        recipeView.printRecipeCreated(recipe);
    }

    public void deleteRecipe() {
        String id = recipeView.readRecipeId();
        if(id != null) {
            try {
                commentService.deleteCommentsForRecipe(recipeService.findById(Long.parseLong(id)));
                recipeService.deleteRecipe(id);
                recipeView.printRecipeDeleted(id);
            } catch (ModelNotFoundException e) {
                recipeView.printIncorrectId(id);
            } catch (CredentialNotFoundException e) {
                recipeView.printCredentialsNotFound();
            }
        }
    }
}
