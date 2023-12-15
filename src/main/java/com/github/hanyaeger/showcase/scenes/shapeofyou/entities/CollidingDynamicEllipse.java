package com.github.hanyaeger.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicEllipseEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.paint.Color;

import java.util.List;

public class CollidingDynamicEllipse extends DynamicEllipseEntity implements SceneBorderTouchingWatcher, Collided, Collider {

    public CollidingDynamicEllipse(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadiusX(40);
        setRadiusY(10);
        setOpacity(0.8);
        setFill(Color.BLACK);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(4);
        setMotion(5, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        changeDirection(180);
    }
}
