package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.service.CookbookBaseService;
import org.springframework.stereotype.Component;

@Component
public class CookbookCommentService extends CookbookBaseService<Comment> implements CommentService {

    public static final String FILE_NAME = "comments.txt";

    public CookbookCommentService() {
        super(FILE_NAME);
    }

    @Override
    public void saveComment(Recipe recipe, String comment) {

    }
}
