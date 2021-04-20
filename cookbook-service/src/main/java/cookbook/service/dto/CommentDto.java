package cookbook.service.dto;

import java.time.LocalDateTime;

public class CommentDto {

    private LocalDateTime timestamp;
    private String description;

    public CommentDto(LocalDateTime timestamp, String description) {
        this.timestamp = timestamp;
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }
}
