package cookbook.service.recipe;

import cookbook.domain.Recipe;
import cookbook.service.CookbookBaseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CookbookRecipeService extends CookbookBaseService<Recipe> implements RecipeService {

    public CookbookRecipeService() {
        super("recipes.txt");
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public List<Recipe> getRecipes() {
        return null;
    }

    @Override
    public void deleteRecipe(String name) {

    }

    @Override
    public void update(Object observer) {
        System.out.println("RecipeService updated");
    }
}
