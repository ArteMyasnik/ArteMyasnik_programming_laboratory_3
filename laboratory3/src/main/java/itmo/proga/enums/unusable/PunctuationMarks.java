package itmo.proga.enums.unusable;

public enum PunctuationMarks {
    DOT(". "), COMMA(", "), DASH("— "), EXCLAMATION_MARK("! "), QUESTION_MARK("? "), COLON(": "), SEMICOLON("; ");

    private final String punctuationMark;

    PunctuationMarks(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String toString() {
        return punctuationMark;
    }
}