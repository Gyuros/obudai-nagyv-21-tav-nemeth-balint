package cookbook.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe implements Identifiable {

    private long id;
    private String name;
    private int servings;
    private String preparation;
    private Cook uploader;
    private List<Category> categories;
    private List<Ingredient> ingredients;
    private List<Comment> comments = new ArrayList<>();

    public Recipe(long id, String name, int servings, String preparation, Cook uploader, List<Category> categories, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.preparation = preparation;
        this.uploader = uploader;
        this.categories = categories;
        this.ingredients = ingredients;
        uploader.getOwnRecipes().add(this);
    }

    public Recipe(String name, int servings, String preparation, Cook uploader, List<Category> categories, List<Ingredient> ingredients) {
        this(0, name, servings, preparation, uploader, categories, ingredients);
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("[id]%s%s%s" +
                        "[user_id]%s%s%s" +
                        "[name]%s%s%s" +
                        "[ingredients]%s%s%s" +
                        "[preparation]%s%s%s" +
                        "[servings]%s%s%s" +
                        "[categories]%s%s",
                System.lineSeparator(),
                id,
                System.lineSeparator(),
                System.lineSeparator(),
                uploader.getId(),
                System.lineSeparator(),
                System.lineSeparator(),
                name,
                System.lineSeparator(),
                System.lineSeparator(),
                ingredients.stream().map(Ingredient::toString).collect(Collectors.joining(System.lineSeparator())),
                System.lineSeparator(),
                System.lineSeparator(),
                preparation,
                System.lineSeparator(),
                System.lineSeparator(),
                servings,
                System.lineSeparator(),
                System.lineSeparator(),
                categories.stream().map(Enum::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
