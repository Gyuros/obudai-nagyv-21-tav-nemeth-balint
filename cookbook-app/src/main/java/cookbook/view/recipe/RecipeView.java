package cookbook.view.recipe;

import cookbook.service.dto.CookDto;
import cookbook.service.dto.RecipeDto;

import java.util.List;

public interface RecipeView {
    RecipeDto readRecipe(CookDto uploader);

    void printRecipeCreated(RecipeDto recipe);

    void printRecipe(RecipeDto recipe);

    void printUserRecipeOptions();

    void printGuestRecipeOptions();

    void printRecipes(List<RecipeDto> recipes);

    String readRecipeId();

    void printIncorrectId(String id);

    void printRecipeDeleted(String id);

    void printCredentialsNotFound();
}
