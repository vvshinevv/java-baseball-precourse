package baseball.domain;

import baseball.exception.PlayBallIllegalArgumentException;

import static baseball.exception.ExceptionMessage.INVALID_PLAY_BALL_GAME_STATUS_MESSAGE;

public enum GamePlayStatus {
    START(1),
    END(2);

    private final Integer status;

    GamePlayStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public static GamePlayStatus findGamePlayStatus(int input) {
        GamePlayStatus result = null;
        for (GamePlayStatus gamePlayStatus : GamePlayStatus.values()) {
            result = findGamePlayStatus(result, gamePlayStatus, input);
        }

        if (result == null) {
            throw new PlayBallIllegalArgumentException(INVALID_PLAY_BALL_GAME_STATUS_MESSAGE);
        }

        return result;
    }

    private static GamePlayStatus findGamePlayStatus(GamePlayStatus beforePlayStatus, GamePlayStatus gamePlayStatus, int input) {
        if (gamePlayStatus.getStatus() == input) {
            beforePlayStatus = gamePlayStatus;
        }

        return beforePlayStatus;
    }
}
