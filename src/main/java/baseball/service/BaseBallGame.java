package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GamePlayStatus;

import java.util.ArrayList;

public class BaseBallGame {

    public void runPlayBallGame() {
        GamePlayStatus status = GamePlayStatus.START;
        while (!status.equals(GamePlayStatus.END)) {
            Computer computer = Computer.of(Balls.createRandomBalls());
        }
    }
}
