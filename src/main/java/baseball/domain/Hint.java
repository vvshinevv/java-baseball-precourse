package baseball.domain;

public enum Hint {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    Hint(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
