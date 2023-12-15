package com.github.hanyaeger.showcase.scenes.scrollingstones.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.showcase.scenes.scrollingstones.entities.RockOne;
import com.github.hanyaeger.showcase.scenes.scrollingstones.entities.RockThree;
import com.github.hanyaeger.showcase.scenes.scrollingstones.entities.RockTwo;
import com.github.hanyaeger.showcase.shared.explosion.ExplosionAdder;

import java.util.Random;

public class RockSpawner extends EntitySpawner {
    private static final double MARGIN = 20;
    private final double width;
    private final double height;
    private final ExplosionAdder explosionAdder;

    public RockSpawner(long intervalInMs, double width, double height, final ExplosionAdder explosionAdder) {
        super(intervalInMs);
        this.width = width;
        this.height = height;
        this.explosionAdder = explosionAdder;
    }

    @Override
    protected void spawnEntities() {

        var location = new Coordinate2D();
        var direction = 0D;

        // We select a random scene border, from which the rock should emerge
        switch (SceneBorder.values()[new Random().nextInt(SceneBorder.values().length)]) {
            case BOTTOM -> {
                location = new Coordinate2D(new Random().nextInt((int) width), height + MARGIN);
                direction = Direction.UP.getValue();
            }
            case TOP -> {
                location = new Coordinate2D(new Random().nextInt((int) width), -MARGIN);
                direction = Direction.DOWN.getValue();
            }
            case LEFT -> {
                location = new Coordinate2D(-MARGIN, new Random().nextInt((int) height));
                direction = Direction.RIGHT.getValue();
            }
            case RIGHT -> {
                location = new Coordinate2D(width + MARGIN, new Random().nextInt((int) height));
                direction = Direction.LEFT.getValue();
            }
        }

        // Add a random delta to the direction
        direction = new Random().nextBoolean() ? direction + new Random().nextInt(30) : direction - new Random().nextInt(30);

        spawn(createRock(location, direction));
    }

    private YaegerEntity createRock(Coordinate2D location, double direction) {
        YaegerEntity rock;
        switch (new Random().nextInt(3)) {
            case 0 -> rock = new RockOne(location, direction, 8, explosionAdder);
            case 1 -> rock = new RockTwo(location, direction, 8, explosionAdder);
            default -> rock = new RockThree(location, direction, 9, explosionAdder);
        }
        return rock;
    }
}
