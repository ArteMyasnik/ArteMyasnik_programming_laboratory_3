package itmo.proga.exceptions;

public class CharacterIsNotInVehicle extends RuntimeException {
    public CharacterIsNotInVehicle(String message) {
        super(message);
    }

    public CharacterIsNotInVehicle(String message, Throwable cause) {
        super(message, cause);
    }
}
