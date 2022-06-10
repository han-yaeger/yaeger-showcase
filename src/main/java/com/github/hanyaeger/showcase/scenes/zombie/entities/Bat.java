package com.github.hanyaeger.showcase.scenes.zombie.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Bat extends DynamicSpriteEntity implements TimerContainer, SceneBorderTouchingWatcher {

    private static final int AUTOCYCLE_SPEED = 90;

    public Bat(final Coordinate2D initialLocation) {
        super("entities/bat-spritemap.png", initialLocation, 2, 10);
        setAutoCycle(AUTOCYCLE_SPEED, 1);
        setMotion(2, Direction.RIGHT);
    }

    @Override
    public void setupTimers() {
        addTimer(new BatTimer(1000, this));
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection();
    }

    public void changeDirection() {
        // whenever we touch the SceneBorder, we change direction
        changeDirection(180D);
        // Use the mod operator to change the autocycle row
        setAutoCycleRow((getAutoCycleRow() + 1) % 2);
    }

    /**
     * Let's use an inner Class. Since this class will only be used by the {@code Bat}, we can declare it within
     * the {@code Bat} class and make it private.
     */
    private static class BatTimer extends Timer {

        private Bat bat;

        protected BatTimer(final long intervalInMs, final Bat bat) {
            super(intervalInMs);
            this.bat = bat;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            if (new Random().nextInt(6) < 1) {
                bat.changeDirection();
            }
        }
    }
}



