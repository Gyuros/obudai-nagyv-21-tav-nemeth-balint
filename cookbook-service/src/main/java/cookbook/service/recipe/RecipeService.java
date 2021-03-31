package cookbook.service.recipe;

import cookbook.domain.Recipe;
import cookbook.service.Initializable;

import java.util.List;

public interface RecipeService extends Initializable {

    void addRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    void deleteRecipe(String name);
}
