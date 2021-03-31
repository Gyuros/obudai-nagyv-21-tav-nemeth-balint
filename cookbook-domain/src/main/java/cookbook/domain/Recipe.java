package cookbook.domain;

import java.util.List;

public class Recipe {

    private long id;
    private String name;
    private int servings;
    private String preparation;
    private Cook uploader;
    private List<Category> categories;
    private List<Ingredient> ingredients;
    private List<Comment> comments;

    public Recipe(long id, String name, int servings, String preparation, Cook uploader, List<Category> categories, List<Ingredient> ingredients) {
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

    public Cook getUploader() {
        return uploader;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
