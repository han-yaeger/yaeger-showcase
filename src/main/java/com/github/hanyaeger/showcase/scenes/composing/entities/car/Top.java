package com.github.hanyaeger.showcase.scenes.composing.entities.car;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class Top extends RectangleEntity implements Collider {

    public Top(final Coordinate2D initialPosition) {
        super(initialPosition);
        setHeight(40);
        setWidth(120);
        setFill(Car.BODY_COLOR);
    }
}
