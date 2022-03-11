package com.github.hanyaeger.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BouncingYellow extends DynamicSpriteEntity {

    public BouncingYellow(final Coordinate2D initialLocation) {
        super("entities/bouncing-yellow.png", initialLocation, new Size(1757, 126), 1, 14);
        setAutoCycle(20);
    }
}
