package itmo.proga.enums.usable;

import itmo.proga.utils.RandomNumberGenerator;

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
        return numberSeats;
    }

    public String getSizeName() {
        return sizeName;
    }

    public static SizeCar getRandomSizeCar() {
        SizeCar[] sizes = SizeCar.values();
        int randomIndex = RandomNumberGenerator.generateNumber() % sizes.length;
        return sizes[randomIndex];
    }

    @Override
    public String toString() {
        return "SizeCar{" +
                "sizeName='" + sizeName + '\'' +
                ", numberSeats=" + numberSeats +
                '}';
    }
}
