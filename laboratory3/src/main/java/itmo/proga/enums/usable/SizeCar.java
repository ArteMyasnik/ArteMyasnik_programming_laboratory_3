package itmo.proga.enums.usable;

public enum SizeCar {
    SMALL("Маленький", 2),
    MEDIUM("Средний", 5),
    BIG("Большой", 8),
    HUGE("Огромный", 11);

    private final String sizeName;
    private final int numberSeats;

    SizeCar(String sizeName, int numberSeats) {
        this.sizeName = sizeName;
        this.numberSeats = numberSeats;
    }

    public int getNumberSeats() {
        return numberSeats - 1;
    }

    public String getSizeName() {
        return sizeName;
    }

    @Override
    public String toString() {
        return "SizeCar{" +
                "sizeName='" + sizeName + '\'' +
                ", numberSeats=" + numberSeats +
                '}';
    }
}
