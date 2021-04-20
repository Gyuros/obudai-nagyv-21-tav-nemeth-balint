package cookbook.service.dto;

import cookbook.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class RecipeDto {

    private long id;
    private String name;
    private int servings;
    private String preparation;
    private CookDto uploader;
    private List<Category> categories;
    private List<IngredientDto> ingredients;
    private List<CommentDto> comments;

    public RecipeDto(long id, String name, int servings, String preparation, CookDto uploader, List<Category> categories, List<IngredientDto> ingredients, List<CommentDto> comments) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.preparation = preparation;
        this.uploader = uploader;
        this.categories = categories;
        this.ingredients = ingredients;
        this.comments = comments;
    }

    public RecipeDto(String name, int servings, String preparation, CookDto uploader, List<Category> categories, List<IngredientDto> ingredients) {
        this(0, name, servings, preparation, uploader, categories, ingredients, new ArrayList<>());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getServings() {
        return servings;
    }

    public String getPreparation() {
        return preparation;
    }

    public CookDto getUploader() {
        return uploader;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public List<CommentDto> getComments() {
        return comments;
    }
}
