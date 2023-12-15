package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.AnimationCallback;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.showcase.scenes.burnthewitch.BurnTheWitchScene;

public class MagicSpellCallback implements AnimationCallback {

    private final BurnTheWitchScene zombieScene;
    private final WitchComposition witch;

    public MagicSpellCallback(final BurnTheWitchScene zombieScene, final WitchComposition witch) {
        this.zombieScene = zombieScene;
        this.witch = witch;
    }

    @Override
    public void call() {
        Coordinate2D location;
        // Depending on the direction of the With, the magic spell should be located to either the left or right of
        // her. We use the bounding box of the Witch, including its methods to decide the exact location.
        if (Direction.RIGHT.equals(Direction.valueOf(witch.getDirection()))) {
            location = new Coordinate2D(witch.getBoundingBox().getMaxX() + 20, witch.getBoundingBox().getCenterY());
        } else {
            location = new Coordinate2D(witch.getBoundingBox().getMinX() - 20, witch.getBoundingBox().getCenterY());
        }
        zombieScene.createMagicSpell(location, Direction.valueOf(witch.getDirection()));
    }
}
