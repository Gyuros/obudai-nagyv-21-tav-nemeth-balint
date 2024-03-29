package cookbook.view.recipe;

import cookbook.domain.Category;
import cookbook.domain.Unit;
import cookbook.service.dto.CookDto;
import cookbook.service.dto.IngredientDto;
import cookbook.service.dto.RecipeDto;
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
    public RecipeDto readRecipe(CookDto uploader) {
        println();
        String name = getRecipeName();
        int servings = getRecipeServings();
        List<IngredientDto> ingredients = getRecipeIngredients();
        String preparation = getRecipePreparation();
        List<Category> categories = getRecipeCategories();

        return new RecipeDto(name, servings, preparation, uploader, categories, ingredients);
    }

    @Override
    public void printRecipeCreated(RecipeDto recipe) {
        println();
        print("-- Recipe created with the following informations --",
                "Name:\t\t" + recipe.getName(),
                "Recipe ID: \t" + recipe.getId(),
                "Servings: \t" + recipe.getServings(),
                "Uploader: \t" + recipe.getUploader().getUsername());
    }

    @Override
    public void printRecipe(RecipeDto recipe) {
        println();
        print("\t\t\t-- " + recipe.getName() + " --",
                "Recipe ID: \t" + recipe.getId(),
                "Uploader: \t" + recipe.getUploader().getUsername(),
                "Servings: \t" + recipe.getServings(),
                "Ingredients:");

        print(recipe.getIngredients().stream().map(i -> "\t\t" + i.toString()).toArray());

        print("Preparation:",
                recipe.getPreparation(),
                "Categories:");

        print(recipe.getCategories().stream().map(c -> "\t\t" + c.toString()).toArray());
    }

    @Override
    public void printUserRecipeOptions() {
        println();
        print("1: See comments",
                "2: Write comment",
                "Q: Go back");
    }

    @Override
    public void printGuestRecipeOptions() {
        println();
        print("1: See comments",
                "2: -- Log in to write comments --",
                "Q: Go back");
    }

    @Override
    public void printRecipes(List<RecipeDto> recipes) {
        println();
        AtomicInteger i = new AtomicInteger();
        print(recipes.stream().map(r -> i.getAndIncrement() + ": " + r.getName()).toArray());
        print("Q: Go back");
    }

    @Override
    public String readRecipeId() {
        print("Enter the id of the recipe you want to delete:");
        String id = generalView.getInput();

        print("Are you sure? (Y/N)");
        String answer = generalView.getInput();

        return answer.equalsIgnoreCase("y") ? id : null;
    }

    @Override
    public void printIncorrectId(String id) {
        print("Recipe with id " + id + " not found.");
    }

    @Override
    public void printRecipeDeleted(String id) {
        print("-- Recipe with account ID: " + id + " deleted. --");
    }

    @Override
    public void printCredentialsNotFound() {
        print("You cannot delete another's cook's recipe.");
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

    private List<IngredientDto> getRecipeIngredients() {
        boolean addAnother = true;
        List<IngredientDto> ingredients = new ArrayList<>();

        while (addAnother) {

            print("What kind of ingredients do you need?");
            double amount = Double.parseDouble(generalView.getInput());
            Unit unit = Unit.valueOf(generalView.getInput().toUpperCase());
            String name = generalView.getInput();

            ingredients.add(new IngredientDto(amount, name, unit));

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
