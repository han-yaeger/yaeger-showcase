package com.github.hanyaeger.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class Circle extends CircleEntity implements MouseButtonPressedListener {

    public static final double RADIUS = 30;

    public Circle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(RADIUS);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        remove();
    }
}
