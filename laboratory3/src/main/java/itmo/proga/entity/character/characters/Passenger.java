package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;
import itmo.proga.enums.usable.FuelType;
import itmo.proga.exceptions.CharacterIsNotInVehicle;
import itmo.proga.exceptions.NoMoreSeatsAvailable;
import itmo.proga.interfaces.annotation.Refreshable;
import itmo.proga.item.items.vehicle.Vehicle;

import java.util.Objects;

@Refreshable
public final class Passenger extends Character {
    private Vehicle vehicle = null;

    public Passenger(String name) {
        super(name);
    }

    public boolean isEdibleFuelType() {
        if (this.vehicle == null) {
            throw new CharacterIsNotInVehicle("Character: " + this.getName() + " is not the vehicle");
        }
        return this.getFuelType().isEdible();
    }

    public FuelType getFuelType() {
        if (this.vehicle == null) {
            throw new CharacterIsNotInVehicle("Character: " + this.getName() + " is not the vehicle");
        }
        return this.vehicle.getFuelType();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) throws NoMoreSeatsAvailable {
        if (this.vehicle == null) {
            vehicle.addPassenger(this);
            throw new CharacterIsNotInVehicle("Character: " + this.getName() + " is not the vehicle");
        }
        this.vehicle.removePassenger(this);
        vehicle.addPassenger(this);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + this.getName() + '\'' +
                ", canDrive=" + isCanDrive() +
                ", vehicle=" + (vehicle != null ? vehicle.getTitle() : "нет транспортного средства") +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return Objects.equals(getName(), passenger.getName()) &&
                Objects.equals(vehicle, passenger.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), vehicle);
    }

    @Override
    public boolean isCanDrive() {
        return false;
    }
}
