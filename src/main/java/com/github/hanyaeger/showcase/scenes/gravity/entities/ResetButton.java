package com.github.hanyaeger.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import com.github.hanyaeger.showcase.shared.buttons.BorderButton;
import com.github.hanyaeger.showcase.scenes.gravity.Gravity;

public class ResetButton extends BorderButton {

    public static final String TEXT = "Reset";
    private final Gravity gravity;

    public ResetButton(final Coordinate2D location, final Gravity gravity) {
        super(location, TEXT, 70);
        this.gravity = gravity;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        gravity.resetEntities();
    }
}
