package com.github.hanyaeger.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.paint.Color;

public class RectangularFloor extends RectangleEntity implements Collider {

    public RectangularFloor(final Coordinate2D initialPosition) {
        super(initialPosition);

        setHeight(20);
        setWidth(140);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }
}
