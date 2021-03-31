package cookbook.service.recipe;

import cookbook.domain.Recipe;

import java.util.List;

public interface RecipeService {

    void addRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    void deleteRecipe(String name);
}
