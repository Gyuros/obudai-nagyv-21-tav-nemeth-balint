package cookbook.service.recipe;

import cookbook.exception.ModelNotFoundException;
import cookbook.service.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    void addRecipe(RecipeDto recipe);

    List<RecipeDto> getRecipes();

    void deleteRecipe(String name) throws ModelNotFoundException;
}
