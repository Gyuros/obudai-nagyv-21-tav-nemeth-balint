package cookbook.view.comment;

import cookbook.service.dto.CommentDto;
import cookbook.service.dto.RecipeDto;
import cookbook.service.recipe.RecipeService;
import cookbook.view.BaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookbookCommentView extends BaseView implements CommentView {

    @Autowired
    private RecipeService recipeService;

    @Override
    public void printRecipeComments(RecipeDto recipe) {
        println();
        int i = 1;
        recipe = recipeService.getRefreshed(recipe);
        for (CommentDto comment : recipe.getComments()) {
            print(
                    i++ + ".\t" + comment.getTimestamp(),
                    comment.getDescription());
        }
    }

    @Override
    public void printNewCommentForm() {
        println();
        print("Write your comment (single-ine):");
    }
}
