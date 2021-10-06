package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GamePlayStatus;
import baseball.domain.Hint;
import baseball.domain.HintResult;
import baseball.domain.HintResults;
import baseball.domain.User;
import baseball.io.BaseBallDisplay;

import java.util.ArrayList;

public class BaseBallGame {

    public void runPlayBallGame() {
        GamePlayStatus status = GamePlayStatus.START;
        while (!status.equals(GamePlayStatus.END)) {
            Computer computer = Computer.of(Balls.createRandomBalls());
            HintResults hintResults = HintResults.of(new ArrayList<>());
            userPlayBallGameWithComputer(hintResults, computer);
            status = BaseBallDisplay.outputOfFinishMessage();
        }
    }

    private void userPlayBallGameWithComputer(HintResults hintResults, Computer computer) {
        while (!checkPlayBallStrike(hintResults)) {
            User user = User.of(BaseBallDisplay.input());
            hintResults = Hint.calculateResults(user.getBalls(), computer.getBalls());
            BaseBallDisplay.output(hintResults);
        }
    }

    private Boolean checkPlayBallStrike(HintResults hintResults) {
        Boolean result = Boolean.FALSE;
        for (HintResult hintResult : hintResults.getHintResults()) {
            result = checkStrikeBallCount(hintResult);

        }
        return result;
    }

    private Boolean checkStrikeBallCount(HintResult hintResult) {
        return hintResult.getHint().equals(Hint.STRIKE) && hintResult.getCount().equals(Balls.BALLS_SIZE) ?
                Boolean.TRUE :
                Boolean.FALSE;
    }
}
