package com.github.hanyaeger.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.showcase.scenes.greatballsoffire.entities.timers.RugbyBallTimer;

public class PinkBall extends DynamicSpriteEntity implements TimerContainer {

    public PinkBall(final Coordinate2D location) {
        super("entities/ball-pink.png", location, new Size(60, 60));
        setRotationSpeed(7);
    }

    @Override
    public void setupTimers() {
        addTimer(new RugbyBallTimer(this, 1000));
    }

    public void changeDirection() {
        setRotationSpeed(getRotationSpeed() * -1);
    }
}
