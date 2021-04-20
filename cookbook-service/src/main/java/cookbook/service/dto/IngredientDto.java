package cookbook.service.dto;

import cookbook.domain.Unit;

public class IngredientDto {

    private double amount;
    private String name;
    private Unit unit;

    public IngredientDto(double amount, String name, Unit unit) {
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
