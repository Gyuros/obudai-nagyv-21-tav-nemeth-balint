package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.service.CookbookBaseService;
import org.springframework.stereotype.Component;

@Component
public class CookbookCommentService extends CookbookBaseService<Comment> implements CommentService {

    public CookbookCommentService() {
        super("comments.txt");
    }

    @Override
    public void saveComment(Recipe recipe, String comment) {

    }

    @Override
    public void update(Object observer) {
        System.out.println(dataParser.toString(models));
    }
}
