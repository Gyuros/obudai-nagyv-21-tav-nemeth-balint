package cookbook.persistence.entity;

import cookbook.domain.Unit;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient extends EntityBase {

    private double amount;
    private String name;
    private Unit unit;
    @ManyToOne
    private Recipe recipe;

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", amount, unit, name);
    }
}
