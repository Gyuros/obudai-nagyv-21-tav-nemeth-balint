package cookbook.domain;

import java.time.LocalDateTime;

public class Comment {

    private long id;
    private String description;
    private LocalDateTime timestamp;
    private Cook owner;
    private Recipe recipe;

    public Comment(long id, String description, LocalDateTime timestamp, Cook owner, Recipe recipe) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
        this.owner = owner;
        this.recipe = recipe;
        owner.getComments().add(this);
        recipe.getComments().add(this);
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Cook getOwner() {
        return owner;
    }
}
