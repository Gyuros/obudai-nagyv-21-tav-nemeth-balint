package cookbook.view.comment;

import cookbook.domain.Recipe;
import cookbook.view.BaseView;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CookbookCommentView extends BaseView implements CommentView {

    @Override
    public void printRecipeComments(Recipe recipe) {
        AtomicInteger i = new AtomicInteger(1);
        var comments = recipe.getComments()
                .stream()
                .map(c -> i.getAndIncrement() +
                        ".\t" +
                        c.getTimestamp() +
                        System.lineSeparator() +
                        c.getDescription())
                .toArray();

        print(comments);
    }

    @Override
    public void printNewCommentForm() {

    }
}
