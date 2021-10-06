package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final Integer BALLS_SIZE = 3;
    public static final Integer LOWER_BOUND_OF_RANDOM_BALL_NUMBER = 1;
    public static final Integer UPPER_BOUND_OF_RANDOM_BALL_NUMBER = 10;

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

    public static Balls createRandomBalls() {
        Set<Ball> balls = new HashSet<>();
        while (balls.size() != BALLS_SIZE) {
            Integer generated = Randoms.pickNumberInRange(LOWER_BOUND_OF_RANDOM_BALL_NUMBER, UPPER_BOUND_OF_RANDOM_BALL_NUMBER);
            Ball ball = Ball.of(generated);
            balls.add(ball);
        }
        return Balls.of(new ArrayList<>(balls));
    }
}
