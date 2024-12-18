package itmo.proga.item.items.vehicle;

import itmo.proga.entity.character.characters.Driver;
import itmo.proga.entity.character.characters.Passenger;
import itmo.proga.enums.usable.FuelType;
import itmo.proga.enums.usable.SizeCar;
import itmo.proga.interfaces.Drivable;
import itmo.proga.interfaces.annotation.Refreshable;
import itmo.proga.item.Item;

import java.util.Objects;

@Refreshable
public abstract class Vehicle extends Item implements Drivable {
    private int fuelLevel;
    private final FuelType type;
    private final SizeCar size;
    private Driver driver;
    private Passenger[] passenger;

    public Vehicle(String title, int fuelLevel, FuelType type, SizeCar size) {
        super(title);
        this.fuelLevel = fuelLevel;
        this.type = type;
        this.size = size;
    }

    public abstract void drive();
    public abstract void snort();
    public abstract void stop();
    public abstract void accelerate();

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public SizeCar getSize() {
        return size;
    }

    public FuelType getType() {
        return type;
    }

    public Driver getDriver() {
        return driver;
    }

    public Passenger[] getPassenger() {
        return passenger;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "title='" + this.getTitle() + '\'' +
                ", isBroken=" + this.isBroken() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return isBroken() == vehicle.isBroken() && Objects.equals(getTitle(), vehicle.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), isBroken(), getFuelLevel(), getFuelLevel(), getSize(), getDriver());
    }
}
