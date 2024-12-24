package itmo.proga.item.items.vehicle;

import itmo.proga.entity.Entity;
import itmo.proga.entity.character.characters.Driver;
import itmo.proga.entity.character.characters.Passenger;
import itmo.proga.enums.usable.FuelType;
import itmo.proga.enums.usable.SizeCar;
import itmo.proga.exceptions.CharacterIsNotInVehicle;
import itmo.proga.exceptions.NoMoreSeatsAvailable;
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
        if (this.getDriver() != null && this.getFuelLevel() > 0) {
            this.setFuelLevel(this.getFuelLevel() - 1);
            System.out.print("ехать ");
        }
    }

    public void snort() {
        if (this.getDriver() != null) {
            System.out.print("фыркать ");
        }
    }

    public void stop() {
        if (this.getDriver() != null) {
            System.out.print("останавливаться ");
        }
    }

    public void accelerate() {
        if (this.getDriver() != null && this.getFuelLevel() > 0) {
            this.setFuelLevel(this.getFuelLevel() - 3);
            System.out.print("ускоряться ");
        }
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

    public void removePassenger(Passenger passenger) {
        if (!passengers.remove(passenger)) {
            throw new CharacterIsNotInVehicle("Character: " + passenger.getName() + " is not the vehicle");
        }
    }


    public void addPassenger(Passenger passenger) throws NoMoreSeatsAvailable {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger could not be null");
        }
        if (!hasAvailableSeats()) {
            throw new NoMoreSeatsAvailable(this, this.getAvailableSeats(), "No more available seats for passengers");
        }
        passengers.add(passenger);
    }

    public int getAvailableSeats() {
        return size.getNumberSeats() - passengers.size();
    }

    public boolean hasAvailableSeats() {
        return getAvailableSeats() > 0;
    }


    public void crush(Entity entity) {
        System.out.print(this.getDriver() + " почти раздавил " + entity.getName() + " ");
    }

    public void smash(Item item) {
        item.breakItem();
        System.out.print(this.getDriver() + " сломал " + item.getTitle() + " ");
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
