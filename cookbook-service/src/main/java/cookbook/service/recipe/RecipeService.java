package cookbook.service.recipe;

import cookbook.exception.ModelNotFoundException;
import cookbook.service.BaseService;
import cookbook.service.Observable;

import java.util.List;

public interface RecipeService extends BaseService<Recipe>, Observable {

    void addRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    void deleteRecipe(String name) throws ModelNotFoundException;
}
