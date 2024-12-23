package itmo.proga.entity.character;

import itmo.proga.entity.Entity;

import java.util.Objects;


public abstract class Character extends Entity {

    public abstract boolean isCanDrive();

    public Character(String name) {
        super(name);
    }

    public void shout() {
        System.out.print("кричать во все горло ");
    }

    public void learnDrive() {
        System.out.print("научиться управлять автомобилем ");
    }

    public void drive() {
        System.out.print("управлять автомобилем ");
    }

    public void runOut() {
        System.out.print("выбежать ");
    }

    public void see() {
        System.out.print("увидеть ");
    }

    public void ask() {
        System.out.print("стал просить ");
    }

    public void openFence() {
        System.out.print("открыть ворота ");
    }

    public void workingOut() {
        System.out.print("получаться ");
    }

    public void getIntoCar() {
        System.out.print("сесть в автомобиль ");
    }

    public void catchUp() {
        System.out.print("догнать ");
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
