package com.github.hanyaeger.showcase.scenes.burnthewitch.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch.WitchComposition;

import java.util.List;
import java.util.Random;

public class Bat extends DynamicSpriteEntity implements TimerContainer, SceneBorderTouchingWatcher, Collider, Collided {

    private static final int AUTOCYCLE_SPEED = 90;
    private WitchComposition witch;

    public Bat(final Coordinate2D initialLocation, final WitchComposition witch) {
        super("entities/bat-spritemap.png", initialLocation, 2, 10);
        this.witch = witch;
        setAutoCycle(AUTOCYCLE_SPEED, 1);
        setMotion(2, Direction.RIGHT);
    }

    @Override
    public void setupTimers() {
        addTimer(new BatTimer(this));
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

    private void followWitch() {
        setDirection(angleTo(witch));

        if (getDirection() > 0 && getDirection() < 180) {
            setAutoCycleRow(1);
        } else {
            setAutoCycleRow(0);
        }
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        changeDirection(180);
    }

    /**
     * Let's use an inner Class. Since this class will only be used by the {@code Bat}, we can declare it within
     * the {@code Bat} class and make it private.
     */
    private static class BatTimer extends Timer {

        private Bat bat;

        protected BatTimer(final Bat bat) {
            super(new Random().nextInt(500) + 200);
            this.bat = bat;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            if (new Random().nextInt(6) < 1) {
                bat.followWitch();
            }
        }
    }
}



