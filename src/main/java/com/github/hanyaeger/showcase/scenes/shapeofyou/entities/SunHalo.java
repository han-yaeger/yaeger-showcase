package com.github.hanyaeger.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

public class SunHalo extends CircleEntity {

    public SunHalo(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(60);
        setFill(Color.LIGHTYELLOW);
        setOpacity(0.5);
        setStrokeWidth(0);
    }
}
