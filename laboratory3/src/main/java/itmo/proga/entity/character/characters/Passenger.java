package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;
import itmo.proga.enums.usable.FuelType;
import itmo.proga.interfaces.annotation.Refreshable;
import itmo.proga.item.items.vehicle.Vehicle;

import java.util.Objects;

@Refreshable
public final class Passenger extends Character {
    private Vehicle vehicle;
    public Passenger(String name, Vehicle vehicle) {
        super(name);
        this.vehicle = vehicle;
        vehicle.addPassenger(this);
    }

    public boolean isEdibleFuelType() {
        return this.getFuelType().isEdible();
    }
    public FuelType getFuelType() {
        return this.vehicle.getType();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle.removePassenger(this);
        vehicle.addPassenger(this);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + this.getName() + '\'' +
                ", canDrive=" + isCanDrive() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return Objects.equals(getName(), passenger.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isCanDrive());
    }

    @Override
    public boolean isCanDrive() {
        return false;
    }
}
