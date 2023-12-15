package com.github.hanyaeger.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RollingTextEntity extends DynamicTextEntity implements SceneBorderTouchingWatcher {

    public RollingTextEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setText("Rolling");
        setFill(YaegerShowCase.HAN_RED);
        setMotion(5, Direction.LEFT);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setRotationSpeed(4);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirection(180);
        setRotationSpeed(-1 * getRotationSpeed());
    }
}
