package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.service.CookbookBaseService;
import cookbook.service.cook.CookbookCookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CookbookCommentService extends CookbookBaseService<Comment> implements CommentService {

    private static final String FILE_NAME = "comments.txt";

    @Autowired
    private CookbookCookService cookService;

    public CookbookCommentService() {
        super(FILE_NAME);
    }

    @Override
    public void saveComment(Recipe recipe, String comment) {
        long lastId = models.stream()
                .map(Comment::getId)
                .max(Long::compare)
                .orElse(1L);

        Comment newComment = new Comment(
                lastId + 1,
                comment,
                LocalDateTime.now(),
                cookService.getCurrentUser(),
                recipe);

        models.add(newComment);
    }
}
