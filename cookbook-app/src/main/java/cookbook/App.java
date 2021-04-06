package cookbook;

import cookbook.service.cook.CookService;
import cookbook.service.comment.CommentService;
import cookbook.service.recipe.RecipeService;
import cookbook.view.GeneralView;
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

    public void start() {
        try {
            cookService.init();
            recipeService.init();
            commentService.init();
            cookService.add(recipeService);
            cookService.add(commentService);
//            cookService.logout();
            generalView.printWelcome();
            generalView.getInput();
            generalView.printWelcome();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
