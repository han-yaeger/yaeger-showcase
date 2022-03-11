package com.github.hanyaeger.showcase.scenes.composing.entities.car.wheel;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;

public class Spoke extends RectangleEntity {

    public Spoke(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(60);
        setHeight(1);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeWidth(0);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
