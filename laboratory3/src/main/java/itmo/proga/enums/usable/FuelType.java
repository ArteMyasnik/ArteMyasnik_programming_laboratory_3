package itmo.proga.enums.usable;

public enum FuelType {
    DIESEL("Дизель", false),
    GASOLINE("Бензин", false),
    FANTA("Фанта", true),
    COKE("Кока-кола", true),
    SPRITE("Спрайт", true),
    SYRUP("Сироп", true),
    ELECTRIC("Электричество", false),
    WATER("Вода", true);

    private final String fuelType;
    private final boolean isEdible;

    FuelType(String fuelType, boolean isEdible) {
        this.fuelType = fuelType;
        this.isEdible = isEdible;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isEdible() {
        return isEdible;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelType='" + fuelType + '\'' +
                ", isEdible=" + isEdible +
                '}';
    }
}
