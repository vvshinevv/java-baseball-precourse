package baseball.io;


import baseball.domain.Balls;
import baseball.domain.GamePlayStatus;
import baseball.domain.Hint;
import baseball.domain.HintResult;
import baseball.domain.HintResults;
import baseball.exception.PlayBallIllegalArgumentException;
import nextstep.utils.Console;

import java.util.List;

import static baseball.exception.ExceptionMessage.INVALID_PLAY_BALL_TEXT;

public class BaseBallDisplay {

    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String OUTPUT_OF_FINISH_MESSAGE = Balls.BALLS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String OUTPUT_OF_RE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";


    public static Balls input() {
        System.out.print(INPUT_MESSAGE);
        String[] inputs = Console.readLine().split("");
        return ofBalls(inputs);
    }

    private static Balls ofBalls(String[] inputs) {
        try {
            return Balls.of(inputs);
        } catch (PlayBallIllegalArgumentException e) {
            BaseBallDisplay.printErrorMessage(e.getMessage());
            return input();
        } catch (NumberFormatException e) {
            BaseBallDisplay.printErrorMessage(INVALID_PLAY_BALL_TEXT);
            return input();
        }
    }

    public static void output(HintResults hintResults) {
        List<HintResult> results = hintResults.getHintResults();
        for (HintResult result : results) {
            printHintMessage(result);
        }
        System.out.println();
    }

    private static void printHintMessage(HintResult result) {

        if (result.getHint().equals(Hint.NOTHING) && result.getCount().equals(Balls.BALLS_SIZE)) {
            System.out.print(result.getHint().getDescription());
            return;
        }

        if (!result.getHint().equals(Hint.NOTHING) && !result.getCount().equals(0)) {
            System.out.print(result.getCount() + result.getHint().getDescription() + " ");
        }
    }

    public static GamePlayStatus outputOfFinishMessage(Boolean flag) {
        if (flag == Boolean.TRUE) {
            System.out.println(OUTPUT_OF_FINISH_MESSAGE);
        }
        System.out.println(OUTPUT_OF_RE_MESSAGE);
        String input = Console.readLine();

        try {
            return GamePlayStatus.findGamePlayStatus(Integer.parseInt(input));
        } catch (PlayBallIllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return outputOfFinishMessage(Boolean.FALSE);
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
