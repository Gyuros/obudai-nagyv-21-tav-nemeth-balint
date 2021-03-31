package cookbook.service.comment;

import cookbook.domain.Recipe;
import cookbook.service.Initializable;

public interface CommentService extends Initializable {

    void saveComment(Recipe recipe, String comment);
}
