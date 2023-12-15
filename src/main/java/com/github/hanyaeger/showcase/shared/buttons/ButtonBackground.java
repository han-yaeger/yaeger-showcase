package com.github.hanyaeger.showcase.shared.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class ButtonBackground extends RectangleEntity {

    public ButtonBackground(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition);
        setWidth(size.width());
        setHeight(size.height());
        setFill(Color.BLACK);
        setStrokeWidth(0);
    }
}
