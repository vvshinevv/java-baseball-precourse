package baseball.domain;

import java.util.Objects;

public class Ball {

    private final Integer ball;

    private Ball(Integer ball) {
        this.ball = ball;
    }

    public static Ball of(Integer ball) {
        return new Ball(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return Objects.equals(ball, ball1.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
