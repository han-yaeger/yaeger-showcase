package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class EffectableEntityForEntityMap extends RectangleEntity {

    public EffectableEntityForEntityMap(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);
        setFill(Color.WHITE);
        setStrokeWidth(1);
        setStrokeColor(Color.BLACK);
        setOpacity(0.5);
    }
}
