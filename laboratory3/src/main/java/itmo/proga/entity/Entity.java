package itmo.proga.entity;

import java.util.Objects;

public class Entity {
    private final String name;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(getName(), entity.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
