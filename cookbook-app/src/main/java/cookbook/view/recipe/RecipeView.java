package cookbook.view.recipe;

import java.util.List;

public interface RecipeView {
    Recipe readRecipe(Cook uploader);

    void printRecipeCreated(Recipe recipe);

    void printRecipe(Recipe recipe);

    void printUserRecipeOptions();

    void printGuestRecipeOptions();

    void printRecipes(List<Recipe> recipes);

    String readRecipeId();

    void printIncorrectId(String id);

    void printRecipeDeleted(String id);

    void printCredentialsNotFound();
}
