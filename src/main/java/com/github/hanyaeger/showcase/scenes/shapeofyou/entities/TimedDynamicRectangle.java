package com.github.hanyaeger.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.shapeofyou.entities.timers.TimedDynamicRectangleTimer;
import javafx.scene.paint.Color;

/**
 * A {@link DynamicRectangleEntity} that uses a {@link com.github.hanyaeger.api.Timer} to change the arcWidth
 * and arcHeight of the rectangle.
 */
public class TimedDynamicRectangle extends DynamicRectangleEntity implements TimerContainer, SceneBorderTouchingWatcher {

    private static final double ARC_MIN = 0;
    private static final double ARC_MAX = 110;
    private double currentArc = 0;
    private boolean decreasing = false;

    public TimedDynamicRectangle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.BLACK);
        setStrokeWidth(4);
        setArc();
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }

    @Override
    public void setupTimers() {
        addTimer(new TimedDynamicRectangleTimer(this, 10));
    }

    public void setArc() {
        if (!decreasing && currentArc < ARC_MAX - 1) {
            currentArc++;
        } else if (decreasing && currentArc > ARC_MIN + 1) {
            currentArc--;
        } else {
            decreasing = !decreasing;
        }

        setArcHeight(currentArc);
        setArcWidth(currentArc);
    }
}
