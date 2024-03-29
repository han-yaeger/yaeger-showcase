package com.github.hanyaeger.showcase.scenes.burnthewitch.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Torch extends DynamicSpriteEntity {

    public Torch(final Coordinate2D initialLocation) {
        super("entities/torch-spritemap.png", initialLocation, 2, 9);
        setAutoCycle(100);
    }
}
