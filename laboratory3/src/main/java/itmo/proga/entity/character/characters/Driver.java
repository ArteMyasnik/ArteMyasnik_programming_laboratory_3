package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;
import itmo.proga.exceptions.CharacterIsNotInVehicle;
import itmo.proga.item.items.vehicle.Vehicle;

import java.util.Objects;

public final class Driver extends Character {
    private Vehicle vehicle;

    public Driver(String name) {
        super(name);
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
                ", vehicle=" + (vehicle != null ? vehicle.getTitle() : "vehicle is null") +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Driver driver = (Driver) obj;
        return Objects.equals(getName(), driver.getName()) &&
                Objects.equals(vehicle, driver.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), vehicle);
    }

    @Override
    public boolean isCanDrive() {
        return true;
    }

    public String decline() {
        return "отказать ";
    }

    public String drive() {
        return "катать ";
    }

    public String pressPedals() {
        return "нажимать педали ";
    }

    public String pullLevers() {
        return "дергать за рычаги ";
    }

    public String grabSteeringWheel() {
        return "ухватиться за руль ";
    }

    public String turn() {
        return "поворачивать ";
    }
}
