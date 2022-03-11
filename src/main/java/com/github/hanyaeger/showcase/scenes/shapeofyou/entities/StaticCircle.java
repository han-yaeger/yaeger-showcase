package com.github.hanyaeger.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.paint.Color;

public class StaticCircle extends CircleEntity {

    public StaticCircle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(40);
        setFill(Color.WHITE);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(3);
    }
}
