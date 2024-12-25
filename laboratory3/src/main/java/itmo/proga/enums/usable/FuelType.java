package itmo.proga.enums.usable;

import itmo.proga.utils.RandomNumberGenerator;

public enum FuelType {
    DIESEL("Дизель", false),
    GASOLINE("Бензин", false),
    FANTA("Фанта", true),
    COKE("Кока-кола", true),
    SPRITE("Спрайт", true),
    SYRUP("Сироп", true),
    ELECTRIC("Электричество", false),
    WATER("Вода", true),
    SODA("Газировка", true);

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

    public static FuelType getRandomFuelType() {
        FuelType[] types = FuelType.values();
        int randomIndex = RandomNumberGenerator.generateNumber() % types.length;
        return types[randomIndex];
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelType='" + fuelType + '\'' +
                ", isEdible=" + isEdible +
                '}';
    }
}
