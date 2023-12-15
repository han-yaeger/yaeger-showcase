package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.Floor;

import java.util.List;

public class WitchFloorCollisionBox extends WitchCollisionBox {

    public WitchFloorCollisionBox(final Coordinate2D initialLocation, final WitchComposition witchComposition) {
        super(initialLocation, witchComposition, new Size(18, 40));
    }
    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        for (var collider : collidingObjects) {
            if (parent != null && collider instanceof Floor floor) {
                parent.handleCollision(floor);
            }
        }
    }
}
