package cookbook.view.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.view.BaseView;
import org.springframework.stereotype.Component;

@Component
public class CookbookCommentView extends BaseView implements CommentView {

    @Override
    public void printRecipeComments(Recipe recipe) {
        int i = 1;
        for (Comment comment : recipe.getComments()) {
            print(
                    i++ + ".\t" + comment.getTimestamp(),
                    comment.getDescription());
        }
        println();
    }

    @Override
    public void printNewCommentForm() {
        print("Write your comment (single-ine):");
    }
}
