package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;
import itmo.proga.exceptions.CharacterIsNotInVehicle;
import itmo.proga.item.items.vehicle.Vehicle;

import java.util.Objects;

public final class Driver extends Character {
    private Vehicle vehicle;

    public Driver(String name, Vehicle vehicle) {
        super(name);
        this.vehicle = vehicle;
        if (this.vehicle == null) {
            throw new CharacterIsNotInVehicle("Character: " + this.getName() + " can not be in null Vehicle");
        }
        vehicle.setDriver(this);
    }

    public void setVehicle(Vehicle vehicle) {
        if (this.vehicle == null) {
            vehicle.setDriver(this);
            throw new CharacterIsNotInVehicle("Character: " + this.getName() + " is not the vehicle");
        }
        this.vehicle.setDriver(null);
        vehicle.setDriver(this);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + this.getName() + '\'' +
                ", canDrive=" + isCanDrive() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Driver driver = (Driver) obj;
        return Objects.equals(getName(), driver.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isCanDrive());
    }

    @Override
    public boolean isCanDrive() {
        return true;
    }

    public void decline() {
        System.out.print("отказать ");
    }

    public void drive() {
        System.out.print("катать ");
    }

    public void pressPedals() {
        System.out.print("нажимать педали ");
    }

    public void pullLevers() {
        System.out.print("дергать за рычаги ");
    }

    public void grabSteeringWheel() {
        System.out.print("ухватиться за руль ");
    }

    public void turn() {
        System.out.print("поворачивать ");
    }
}
