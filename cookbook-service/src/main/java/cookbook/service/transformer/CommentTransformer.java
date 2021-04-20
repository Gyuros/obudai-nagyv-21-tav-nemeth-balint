package cookbook.service.transformer;

import cookbook.persistence.entity.Comment;
import cookbook.service.dto.CommentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentTransformer {

    public List<CommentDto> toCommentDtos(List<Comment> comments) {
        return comments.stream().map(c -> new CommentDto(c.getTimestamp(), c.getDescription())).collect(Collectors.toList());
    }
}
