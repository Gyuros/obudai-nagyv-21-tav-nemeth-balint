package cookbook.domain;

public class Ingredient {

    private final double amount;
    private final String name;
    private final Unit unit;

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

    @Override
    public String toString() {
        return String.format("%s %s %s", amount, unit, name);
    }
}
