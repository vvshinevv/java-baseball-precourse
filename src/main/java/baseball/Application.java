package baseball;

import baseball.service.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        BaseBallGame playBallGame = new BaseBallGame();
        playBallGame.runPlayBallGame();
    }
}
