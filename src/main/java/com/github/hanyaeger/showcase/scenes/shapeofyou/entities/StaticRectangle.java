package com.github.hanyaeger.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.paint.Color;

public class StaticRectangle extends RectangleEntity {

    public StaticRectangle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(6);
    }
}
