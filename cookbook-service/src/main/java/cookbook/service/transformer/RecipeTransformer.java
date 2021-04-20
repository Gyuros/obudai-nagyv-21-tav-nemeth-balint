package cookbook.service.transformer;

import cookbook.persistence.entity.Recipe;
import cookbook.service.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecipeTransformer {

    @Autowired
    private IngredientTransformer ingredientTransformer;

    @Autowired
    private CategoryTransformer categoryTransformer;

    @Autowired
    private CookTransformer cookTransformer;

    @Autowired
    private CommentTransformer commentTransformer;

    public Recipe toRecipe(RecipeDto recipeDto) {
        var uploader = cookTransformer.toCook(recipeDto.getUploader());
        var categories = categoryTransformer.toRecipeCategories(recipeDto.getCategories());
        var ingredients = ingredientTransformer.toIngredients(recipeDto.getIngredients());

        return new Recipe(
                recipeDto.getName(),
                recipeDto.getServings(),
                recipeDto.getPreparation(),
                uploader,
                categories,
                ingredients);
    }

    public List<RecipeDto> toRecipeDtos(List<Recipe> recipes) {
        return recipes.stream().map(this::toRecipeDto).collect(Collectors.toList());
    }

    public RecipeDto toRecipeDto(Recipe recipe) {
        return new RecipeDto(
                recipe.getId(),
                recipe.getName(),
                recipe.getServings(),
                recipe.getPreparation(),
                cookTransformer.toCookDto(recipe.getUploader()),
                categoryTransformer.toCategories(recipe.getCategories()),
                ingredientTransformer.toIngredientDtos(recipe.getIngredients()),
                commentTransformer.toCommentDtos(recipe.getComments()));
    }
}
