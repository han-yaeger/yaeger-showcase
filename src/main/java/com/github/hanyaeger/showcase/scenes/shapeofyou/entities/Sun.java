package com.github.hanyaeger.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import javafx.scene.paint.Color;

public class Sun extends CircleEntity {

    public Sun(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(40);
        setFill(Color.YELLOW);
        setStrokeWidth(0);
    }
}
