package nl.han.showcase.scenes.spriteentities.entities.timers;

import com.github.hanyaeger.api.engine.Timer;
import nl.han.showcase.scenes.spriteentities.entities.RugbyBall;

public class RugbyBallTimer extends Timer {

    private RugbyBall rugbyBall;

    public RugbyBallTimer(RugbyBall rugbyBall, int intervalInMs) {
        super(intervalInMs);
        this.rugbyBall = rugbyBall;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        rugbyBall.changeDirection();
    }
}
