package cookbook;

import cookbook.service.comment.CommentService;
import cookbook.service.cook.CookService;
import cookbook.service.dto.RecipeDto;
import cookbook.view.GeneralView;
import cookbook.view.comment.CommentView;
import cookbook.view.cook.CookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMenu {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentView commentView;

    @Autowired
    private CookService cookService;

    @Autowired
    private CookView cookView;

    @Autowired
    private GeneralView generalView;

    public void processRecipeMenuInput(RecipeDto recipe, String input) {
        switch (input){
            case "1": commentView.printRecipeComments(recipe); break;
            case "2": newComment(recipe); break;
        }
    }

    private void newComment(RecipeDto recipe) {
        if(cookService.isLoggedIn()) {
            commentView.printNewCommentForm();
            commentService.saveComment(recipe, generalView.getInput());
        } else {
            cookView.printNotAuthenticated();
        }
    }
}
