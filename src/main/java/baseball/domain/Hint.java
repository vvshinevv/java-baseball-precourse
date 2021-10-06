package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public enum Hint {

    STRIKE("스트라이크") {
        @Override
        public Integer calculateCount(Balls myBalls, Balls yourBalls) {
            return null;
        }
    },
    BALL("볼") {
        @Override
        public Integer calculateCount(Balls myBalls, Balls yourBalls) {
            return null;
        }
    },
    NOTHING("낫싱") {
        @Override
        public Integer calculateCount(Balls myBalls, Balls yourBalls) {
            return null;
        }
    };

    private final String description;

    Hint(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract Integer calculateCount(Balls myBalls, Balls yourBalls);

    public static HintResults calculateResults(Balls myBalls, Balls yourBalls) {
        List<HintResult> hintResults = new ArrayList<>();
        for (Hint hint : Hint.values()) {
            HintResult hintResult = HintResult.of(hint, hint.calculateCount(myBalls, yourBalls));
            hintResults.add(hintResult);
        }
        return HintResults.of(hintResults);
    }
}
