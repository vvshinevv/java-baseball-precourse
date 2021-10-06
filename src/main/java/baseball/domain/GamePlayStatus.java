package baseball.domain;

public enum GamePlayStatus {
    START(0),
    RE_START(1),
    END(2);

    private final Integer status;

    GamePlayStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
