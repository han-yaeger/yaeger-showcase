package com.github.hanyaeger.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SpinningTextEntity extends DynamicTextEntity {

    public SpinningTextEntity(final Coordinate2D initialPosition) {
        super(initialPosition);
        setText("Spinning");
        setFill(YaegerShowCase.HAN_RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setRotationSpeed(-5);
    }
}
