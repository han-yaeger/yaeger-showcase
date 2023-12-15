package com.github.hanyaeger.showcase.scenes.scrollingstones.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Earth extends DynamicSpriteEntity {

    public Earth(Coordinate2D initialLocation) {
        super("entities/earth.png", initialLocation, 12, 5);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAutoCycle(80);
    }
}
