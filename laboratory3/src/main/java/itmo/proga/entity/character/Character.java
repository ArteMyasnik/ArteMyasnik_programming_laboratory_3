package itmo.proga.entity.character;

import itmo.proga.entity.Entity;
import itmo.proga.entity.character.characters.*;
import itmo.proga.enums.unusable.Words;
import itmo.proga.item.items.vehicle.Vehicle;

import java.util.Objects;


public abstract class Character extends Entity {

    public abstract boolean isCanDrive();

    public Character(String name) {
        super(name);
    }

    public Driver becomeDriver() {
        return (Driver) this;
    }

    public Passenger becomePassenger() {
        return (Passenger) this;
    }

    public String wantTo() {
        return "хотеть ";
    }

    public String can() {
        return "мог ";
    }

    public String love() {
        return "любить ";
    }

    public String shout() {
        return "кричать во все горло ";
    }

    public String ride() {
        return "кататься ";
    }

    public String build() {
        return "соорудить ";
    }

    public String learnDrive() {
        return "научиться управлять" + Words.THIS + "автомобилем ";
    }

    public String drive() {
        return "управлять автомобилем ";
    }

    public String drink() {
        return "пить ";
    }

    public String runOut() {
        return "выбежать ";
    }

    public String see() {
        return "увидеть ";
    }

    public String ask(Character character) {
        return "стал просить " + character.getName();
    }

    public String openFence() {
        return "открыть ворота ";
    }

    public String frightened() {
        return "испугаться ";
    }

    public String workingOut() {
        return "получаться ";
    }

    public String getIntoCar(Vehicle vehicle) {
        return "сесть " + Words.IN + vehicle.getTitle();
    }

    public String catchUp() {
        return "догнать ";
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + this.getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return Objects.equals(getName(), character.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
