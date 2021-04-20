package cookbook.persistence.entity;

import cookbook.domain.Unit;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient extends EntityBase {

    private double amount;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Unit unit;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(double amount, String name, Unit unit, Recipe recipe) {
        this.amount = amount;
        this.name = name;
        this.unit = unit;
        this.recipe = recipe;
    }

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
