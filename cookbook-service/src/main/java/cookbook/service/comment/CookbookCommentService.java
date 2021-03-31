package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.persistence.Data;
import cookbook.util.CommentDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CookbookCommentService implements CommentService {

    private static final String INIT_FILE = "comments.txt";
    private List<Comment> comments;

    @Autowired
    private Data data;

    @Autowired
    private CommentDataParser commentDataParser;

    @Override
    public void init() throws IOException {
        String initData = data.read(INIT_FILE);
        comments = commentDataParser.parse(initData);
    }

    @Override
    public void saveComment(Recipe recipe, String comment) {

    }
}
