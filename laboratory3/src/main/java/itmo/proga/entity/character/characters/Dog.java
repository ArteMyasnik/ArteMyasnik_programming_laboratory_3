package itmo.proga.entity.character.characters;

public record Dog(String name) {
    public String jumpOut() {
        return "успел выскочить ";
    }

    public String getName() {
        return name;
    }
}
