package cookbook.service.recipe;

import cookbook.domain.Recipe;
import cookbook.service.CookbookBaseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CookbookRecipeService extends CookbookBaseService<Recipe> implements RecipeService {

    public static final String FILE_NAME = "recipes.txt";

    public CookbookRecipeService() {
        super(FILE_NAME);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        models.add(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return null;
    }

    @Override
    public void deleteRecipe(String name) {

    }
}
