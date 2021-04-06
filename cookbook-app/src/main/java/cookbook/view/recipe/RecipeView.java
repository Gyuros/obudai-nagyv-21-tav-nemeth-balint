package cookbook.view.recipe;

import cookbook.domain.Cook;
import cookbook.domain.Recipe;

import java.util.List;

public interface RecipeView {
    Recipe readRecipe(Cook uploader);

    void printRecipeShort(Recipe recipe);

    void printRecipeLong(Recipe recipe);

    void printUserRecipeOptions();

    void printGuestRecipeOptions();

    void printRecipes(List<Recipe> recipes);

    String readRecipeId();
}
