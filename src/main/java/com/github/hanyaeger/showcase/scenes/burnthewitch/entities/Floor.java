package com.github.hanyaeger.showcase.scenes.burnthewitch.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

/**
 * The {@code Floor} will need the exact same behaviour as the floor, but the interaction with the
 * {@link com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch.Witch} will be a bit different.
 * Therefore, we create this new class, so the {@link com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch.Witch}
 * can figure out with which she is colliding and how she should behave.
 */
public class Floor extends WitchCollidingBox {

    public Floor(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }
}
