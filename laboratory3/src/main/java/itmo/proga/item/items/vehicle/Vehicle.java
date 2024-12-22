package itmo.proga.item.items.vehicle;

import itmo.proga.entity.character.characters.Driver;
import itmo.proga.entity.character.characters.Passenger;
import itmo.proga.enums.usable.FuelType;
import itmo.proga.enums.usable.SizeCar;
import itmo.proga.interfaces.Drivable;
import itmo.proga.interfaces.annotation.Refreshable;
import itmo.proga.item.Item;

import java.util.*;

@Refreshable
public class Vehicle extends Item implements Drivable {
    private int fuelLevel;
    private final FuelType type;
    private final SizeCar size;
    private Driver driver;
    private final List<Passenger> passengers;

    public Vehicle(String title, int fuelLevel, FuelType type, SizeCar size) {
        super(title);
        this.fuelLevel = fuelLevel;
        this.type = type;
        this.size = size;
        this.passengers = new ArrayList<>(size.getNumberSeats());
    }

    public void drive() {
        System.out.print("ехать ");
    }
    public void snort() {
        System.out.print("фыркать ");
    }
    public void stop() {
        System.out.print("останавливаться ");
    }
    public void accelerate() {
        System.out.print("ускоряться ");
    }

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
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Passenger> getPassenger() {
        return Collections.unmodifiableList(passengers);
    }
    public void addPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Пассажир не может быть null");
        }
        if (passengers.size() >= size.getNumberSeats()) {
            throw new IllegalArgumentException("Больше нет мест для пассажиров");
        }
        passengers.add(passenger);
    }
    public void removePassenger(Passenger passenger) {
        if (!passengers.remove(passenger)) {
            throw new IllegalArgumentException("Пассажир не был в транспортном средстве");
        }
    }
    public int getAvailableSeats() {
        return size.getNumberSeats() - passengers.size();
    }
    public boolean hasAvailableSeats() {
        return getAvailableSeats() > 0;
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
        return isBroken() == vehicle.isBroken() &&
                fuelLevel == vehicle.fuelLevel &&
                Objects.equals(getTitle(), vehicle.getTitle()) &&
                type == vehicle.type &&
                size == vehicle.size &&
                Objects.equals(driver, vehicle.driver) &&
                Objects.equals(passengers, vehicle.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), isBroken(), getFuelLevel(), getFuelLevel(), getSize(), getType(), getDriver(), getPassenger(), getAvailableSeats());
    }
}
