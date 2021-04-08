package cookbook.domain;

import java.time.LocalDateTime;

public class Comment implements Identifiable {

    private final long id;
    private final String description;
    private final LocalDateTime timestamp;
    private final Cook owner;
    private final Recipe recipe;

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

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id, recipe.getId(), owner.getId(), timestamp, description);
    }
}
