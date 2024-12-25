package itmo.proga.enums.usable.supportive;

import itmo.proga.enums.usable.FuelType;
import itmo.proga.enums.usable.TypeCar;

import java.util.HashMap;
import java.util.Map;

public class CarFuelTypeMapper {
    private static final Map<TypeCar, FuelType> carToFuelMap = new HashMap<>();

    private static final Map<FuelType, TypeCar> fuelToCarMap = new HashMap<>();

    static {
        addMapping(TypeCar.DIESEL, FuelType.DIESEL);
        addMapping(TypeCar.GASOLINE, FuelType.GASOLINE);
        addMapping(TypeCar.FANTA, FuelType.FANTA);
        addMapping(TypeCar.COKE, FuelType.COKE);
        addMapping(TypeCar.SPRITE, FuelType.SPRITE);
        addMapping(TypeCar.SYRUP, FuelType.SYRUP);
        addMapping(TypeCar.ELECTRIC, FuelType.ELECTRIC);
        addMapping(TypeCar.WATER, FuelType.WATER);
        addMapping(TypeCar.SODA, FuelType.SODA);
    }

    public static void addMapping(TypeCar typeCar, FuelType fuelType) {
        carToFuelMap.put(typeCar, fuelType);
        fuelToCarMap.put(fuelType, typeCar);
    }

    public static FuelType getFuelType(TypeCar typeCar) {
        return carToFuelMap.get(typeCar);
    }

    public static TypeCar getTypeCar(FuelType fuelType) {
        return fuelToCarMap.get(fuelType);
    }
}