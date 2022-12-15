package com.github.hanyaeger.showcase.scenes.burnthewitch.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Fence extends SpriteEntity {

    public Fence(Coordinate2D initialLocation) {
        super("entities/fence.png", initialLocation);
        // The Fence should be placed in the front
        setViewOrder(6);
    }
}
