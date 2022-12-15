package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class MagicSpell extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher {

    public MagicSpell(final Coordinate2D initialLocation, final Direction direction) {
        super("entities/magic-spell.png", initialLocation, 2, 6);
        setAutoCycle(100);
        setMotion(3, direction);
        if (direction.equals(Direction.RIGHT)) {
            setAutoCycleRow(1);
        } else {
            setAutoCycleRow(0);
        }
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        remove();
    }
}
