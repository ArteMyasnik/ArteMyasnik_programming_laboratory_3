package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;
import itmo.proga.interfaces.annotation.Refreshable;

import java.util.Objects;

@Refreshable
public final class Passenger extends Character {
    public Passenger(String name) {
        super(name);
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
