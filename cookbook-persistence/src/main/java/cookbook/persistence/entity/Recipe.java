package cookbook.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Recipe extends EntityBase {

    private String name;
    private int servings;

    @Column(length = 2000)
    private String preparation;

    @ManyToOne
    private Cook uploader;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeCategory> categories;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String name, int servings, String preparation, Cook uploader, List<RecipeCategory> categories, List<Ingredient> ingredients) {
        this.name = name;
        this.servings = servings;
        this.preparation = preparation;
        this.uploader = uploader;
        this.categories = categories;
        this.ingredients = ingredients;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<RecipeCategory> getCategories() {
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
                categories.stream().map(RecipeCategory::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
