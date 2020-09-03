package nl.han.showcase.scenes.spriteentities.entities.timers;

import com.github.hanyaeger.api.engine.Timer;
import nl.han.showcase.scenes.spriteentities.entities.PinkBall;

public class RugbyBallTimer extends Timer {

    private PinkBall pinkBall;

    public RugbyBallTimer(PinkBall pinkBall, int intervalInMs) {
        super(intervalInMs);
        this.pinkBall = pinkBall;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        pinkBall.changeDirection();
    }
}
