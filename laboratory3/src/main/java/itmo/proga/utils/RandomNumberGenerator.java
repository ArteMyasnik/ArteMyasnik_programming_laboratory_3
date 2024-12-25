package itmo.proga.utils;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {}

    public static int generateNumber() {
        int number = (int) (Math.random() * 100);

        if (number == 0) {
            throw new IllegalArgumentException("Min number should be less than max number");
        }
        return number;
    }
}