package com.github.hanyaeger.showcase.scenes.zombie.entities.timers;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.showcase.scenes.zombie.entities.PinkBall;

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
