package cookbook.domain;

public class Ingredient {

    private double amount;
    private String name;

    public Ingredient(double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
