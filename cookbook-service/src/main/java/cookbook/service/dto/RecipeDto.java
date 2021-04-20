package cookbook.service.dto;

import cookbook.domain.Category;

import java.util.List;

public class RecipeDto {

    private long id;
    private String name;
    private int servings;
    private String preparation;
    private CookDto uploader;
    private List<Category> categories;
    private List<IngredientDto> ingredients;

    public RecipeDto(long id, String name, int servings, String preparation, CookDto uploader, List<Category> categories, List<IngredientDto> ingredients) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.preparation = preparation;
        this.uploader = uploader;
        this.categories = categories;
        this.ingredients = ingredients;
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
}
