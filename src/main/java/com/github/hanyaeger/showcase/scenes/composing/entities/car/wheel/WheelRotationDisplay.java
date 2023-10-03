package com.github.hanyaeger.showcase.scenes.composing.entities.car.wheel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;

/**
 * To continually show the rotation of the wheel, a {@link DynamicTextEntity} will become a
 * {@link com.github.hanyaeger.api.UpdateExposer}, and on each {@link com.github.hanyaeger.api.UpdateExposer#explicitUpdate(long)}
 * it will call {@link YaegerEntity#getRotation()} and display its value.
 */
public class WheelRotationDisplay extends DynamicTextEntity implements UpdateExposer {

    private final Wheel wheel;

    public WheelRotationDisplay(final Coordinate2D initialLocation, final Wheel wheel) {
        super(initialLocation);

        this.wheel = wheel;
        setFill(YaegerShowCase.HAN_RED);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        setText("Rotation in degrees: " + wheel.getRotation());
    }
}
