package cookbook;

import cookbook.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommentMenu {

    @Autowired
    private CommentService commentService;

    public void init() {
        try {
            commentService.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
