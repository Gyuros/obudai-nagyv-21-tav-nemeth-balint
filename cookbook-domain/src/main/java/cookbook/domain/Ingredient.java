package cookbook.domain;

public class Ingredient {

    private double amount;
    private String name;
    private Unit unit;

    public Ingredient(double amount, String name, Unit unit) {
        this.amount = amount;
        this.name = name;
        this.unit = unit;
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
}
