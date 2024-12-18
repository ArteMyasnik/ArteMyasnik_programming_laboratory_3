package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;

import java.util.Objects;

public final class Driver extends Character {
    public Driver(String name) {
        super(name);
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
