package itmo.proga.enums.usable;

import itmo.proga.utils.RandomNumberGenerator;

public enum TypeCar {
    DIESEL("Дизельный"),
    GASOLINE("Бензиновый"),
    FANTA("Фантовый"),
    COKE("Кока-кольный"),
    SPRITE("Спрайтовый"),
    SYRUP("Сиропный"),
    ELECTRIC("Электрический"),
    WATER("Водяной"),
    SODA("Газированный");

    private final String typeCar;

    TypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getTypeCar() {
        return typeCar;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelType='" + typeCar + '\'' +
                '}';
    }
}
