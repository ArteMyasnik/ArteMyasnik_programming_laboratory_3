package itmo.proga.enums.unusable;

public enum Words {
    SUCH("такие "), BIG_SUCH("Такие "),
    WAS("был "), BIG_WAS("Был "),
    WERE("были "), BIG_WERE("Были "),
    BUT("но "), BIG_BUT("Но "),
    IN("в "), BIG_IN("В "),
    AND("и "), BIG_AND("И "),
    HAD("имелось "), BIG_HAD("Имелось "),
    ONE("одно "), BIG_ONE("Одно "),
    VERY("очень "), BIG_VERY("Очень "),
    WITH("с "), BIG_WITH("С "),
    THIS("этим "), BIG_THIS("Этим "),
    IF("если "), BIG_IF("Если "),
    SOMEONE("кто-нибудь "), BIG_SOMEONE("Кто-нибудь "),
    NOBODY("никто "), BIG_NOBODY("Никто "),
    BECAUSE("так как "), BIG_BECAUSE("Так как "),
    ON("на "), BIG_ON("На "),
    TOO("тоже "), BIG_TOO("Тоже "),
    ONCE("однажды "), BIG_ONCE("Однажды "),
    SUDDENLY("вдруг "), BIG_SUDDENLY("Вдруг "),
    FIRSTLY("сначала "), BIG_FIRSTLY("Сначала "),
    NOTHING("ничего "), BIG_NOTHING("Ничего "),
    THEN("потом "), BIG_THEN("Потом "),
    FROM("из "), BIG_FROM("Из "),
    INSTEADOF("вместо "), BIG_INSTEADOF("Вместо "),
    MORE("ещё "), BIG_MORE("Ещё "),
    A("а "), BIG_A("А ");

    private final String word;

    Words(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
