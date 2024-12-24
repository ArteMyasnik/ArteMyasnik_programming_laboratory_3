package itmo.proga.exceptions;

import itmo.proga.item.items.vehicle.Vehicle;

public class NoMoreSeatsAvailable extends Exception {
    private final Vehicle vehicle;
    private final int passengerSeats;

    public NoMoreSeatsAvailable(Vehicle vehicle, int passengerSeats, String message) {
        super(message);
        this.vehicle = vehicle;
        this.passengerSeats = passengerSeats;
    }

    @Override
    public String getMessage() {
        return "The " + this.vehicle.getTitle() + " has not more available seats than " + this.passengerSeats + ": " + super.getMessage();
    }
}
