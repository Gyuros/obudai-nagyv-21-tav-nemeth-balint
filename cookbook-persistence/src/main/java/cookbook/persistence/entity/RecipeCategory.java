package cookbook.persistence.entity;

import cookbook.domain.Category;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class RecipeCategory extends EntityBase {

    @ManyToOne
    private Recipe recipe;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    public RecipeCategory() {
    }

    public RecipeCategory(Recipe recipe, Category category) {
        this.recipe = recipe;
        this.category = category;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category.toString();
    }
}
