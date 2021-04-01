package cookbook.service.recipe;

import cookbook.domain.Recipe;
import cookbook.service.BaseService;

import java.util.List;

public interface RecipeService extends BaseService<Recipe> {

    void addRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    void deleteRecipe(String name);
}
