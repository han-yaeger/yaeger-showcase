package com.github.hanyaeger.showcase.scenes.time.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.showcase.scenes.time.entities.Clock;

import java.util.Random;

public class ClockSpawner extends EntitySpawner {

    private static final long INCREMENT_VALUE = 10L;
    private final double sceneWidth;

    public ClockSpawner(final double sceneWidth) {
        super(200);
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Clock(randomLocation()));
    }

    private Coordinate2D randomLocation() {
        var x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, 0);
    }

    public void increaseSpeed() {
        if (getIntervalInMs() > 0) {
            setIntervalInMs(getIntervalInMs() - INCREMENT_VALUE);
        }
    }

    public void decreaseSpeed() {
        setIntervalInMs(getIntervalInMs() + INCREMENT_VALUE);
    }
}
