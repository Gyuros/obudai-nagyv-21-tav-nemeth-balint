package cookbook.util;

import cookbook.domain.Recipe;
import cookbook.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeDataParser implements DataParser<Recipe> {

    @Autowired
    private CategoryDataParser categoryDataParser;

    @Autowired
    private IngredientDataParser ingredientDataParser;

    @Autowired
    private AuthService authService;

    @Override
    public List<Recipe> parse(String text) {
        List<Recipe> recipes = new ArrayList<>();
        String[] datas = text.split("\\[|\\]");

        for (int i = 0; i < datas.length / 14; i++){

            int id = Integer.parseInt(datas[i * 14 + 2].replace("\r\n", ""));
            int userId = Integer.parseInt(datas[i * 14 + 4].replace("\r\n", ""));
            String name = datas[i * 14 + 6];
            String ingredients = datas[i * 14 + 8];
            String preparation = datas[i * 14 + 10];
            int servings = Integer.parseInt(datas[i * 14 + 12].replace("\r\n", ""));
            String categories = datas[i * 14 + 14];

            recipes.add(new Recipe(
                    id,
                    name,
                    servings,
                    preparation,
                    authService.findCookById(userId),
                    categoryDataParser.parse(categories),
                    ingredientDataParser.parse(ingredients)));
        }

        return recipes;
    }
}
