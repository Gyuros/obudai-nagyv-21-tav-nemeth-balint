package cookbook.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Comment extends EntityBase {

    private String description;
    private LocalDateTime timestamp;

    @ManyToOne
    private Cook owner;

    @ManyToOne
    private Recipe recipe;

    public Comment() {
    }

    public Comment(String description, Recipe recipe, Cook owner) {
        this.description = description;
        this.recipe = recipe;
        this.owner = owner;
        this.timestamp = LocalDateTime.now();
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
