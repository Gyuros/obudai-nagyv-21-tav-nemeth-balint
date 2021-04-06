package cookbook.view.recipe;

import cookbook.domain.*;
import cookbook.view.BaseView;
import cookbook.view.GeneralView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CookbookRecipeView extends BaseView implements RecipeView {

    @Autowired
    private GeneralView generalView;

    @Override
    public Recipe readRecipe(Cook uploader) {
        println();
        String name = getRecipeName();
        int servings = getRecipeServings();
        List<Ingredient> ingredients = getRecipeIngredients();
        String preparation = getRecipePreparation();
        List<Category> categories = getRecipeCategories();

        print("-- Recipe created with the following informations --");
        return new Recipe(name, servings, preparation, uploader, categories, ingredients);
    }

    @Override
    public void printRecipeShort(Recipe recipe) {
        print("Name:\t\t" + recipe.getName(),
                "Recipe ID: \t" + recipe.getId(),
                "Servings: \t" + recipe.getServings(),
                "Uploader: \t" + recipe.getUploader().getUsername());
    }

    @Override
    public void printRecipeLong(Recipe recipe) {

    }

    @Override
    public void printUserRecipeOptions() {

    }

    @Override
    public void printGuestRecipeOptions() {

    }

    @Override
    public void printRecipes(List<Recipe> recipes) {

    }

    @Override
    public String readRecipeId() {
        return null;
    }

    private List<Category> getRecipeCategories() {
        print("How would you categorize this dish? (type 'C' to continue)");
        boolean addNewCategory = true;
        List<Category> categories = new ArrayList<>();

        while(addNewCategory){
            AtomicInteger i = new AtomicInteger();
            print(Arrays.stream(Category.values())
                    .map(c -> i.getAndIncrement() + ": " + c.toString())
                    .toArray());

            String input = generalView.getInput();
            if (input.equalsIgnoreCase("c")) {
                addNewCategory = false;
            } else {
                int index = Integer.parseInt(input);
                categories.add(Category.values()[index]);
            }
        }

        return categories;
    }

    private String getRecipePreparation() {
        boolean addNewLine = true;
        print("How do you make this dish? (type 'C' to continue)");
        StringBuilder sb = new StringBuilder();

        while(addNewLine) {
            String line = generalView.getInput();
            if (line.equalsIgnoreCase("c")) {
                addNewLine = false;
            } else {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

        }

        return sb.toString();
    }

    private List<Ingredient> getRecipeIngredients() {
        boolean addAnother = true;
        List<Ingredient> ingredients = new ArrayList<>();

        while (addAnother) {

            print("What kind of ingredients do you need?");
            double amount = Double.parseDouble(generalView.getInput());
            Unit unit = Unit.valueOf(generalView.getInput().toUpperCase());
            String name = generalView.getInput();

            ingredients.add(new Ingredient(amount, name, unit));

            print("Add another? (Y/N)");
            addAnother = generalView.getInput().equalsIgnoreCase("y");
        }

        return ingredients;
    }

    private int getRecipeServings() {
        print("How many people does this dish serve?");
        return Integer.parseInt(generalView.getInput());
    }

    private String getRecipeName() {
        print("What's the name of your dish?");
        return generalView.getInput();
    }
}