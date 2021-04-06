package cookbook;

import cookbook.service.comment.CommentService;
import cookbook.service.cook.CookService;
import cookbook.service.recipe.RecipeService;
import cookbook.view.GeneralView;
import cookbook.view.comment.CommentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class App {

    @Autowired
    private CookService cookService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private GeneralView generalView;

    @Autowired
    private CommentView commentView;

    public void start() {
        try {
            cookService.init();
            recipeService.init();
            commentService.init();
            cookService.add(recipeService);
            cookService.add(commentService);
//            cookService.logout();
            generalView.printWelcome();
            commentView.printRecipeComments(recipeService.getRecipes().stream().findFirst().get());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
