package itmo.proga.entity.character.characters;

public record Dog(String name) {
    public void jumpOut() {
        System.out.print("успел выскочить ");
    }
}
