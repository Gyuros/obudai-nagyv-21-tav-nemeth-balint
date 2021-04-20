package cookbook.view.comment;

import cookbook.view.BaseView;
import org.springframework.stereotype.Component;

@Component
public class CookbookCommentView extends BaseView implements CommentView {

    @Override
    public void printRecipeComments(Recipe recipe) {
        println();
        int i = 1;
        for (Comment comment : recipe.getComments()) {
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
