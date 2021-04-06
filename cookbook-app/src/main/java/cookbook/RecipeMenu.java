package cookbook;

import cookbook.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RecipeMenu {

    @Autowired
    private RecipeService recipeService;

    public void init() {
        try {
            recipeService.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listRecipes() {

    }
}
