package baseball.domain;

import java.util.Collections;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
