package com.github.hanyaeger.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import com.github.hanyaeger.showcase.YaegerShowCase;

/**
 * A {@link SpaceShip} is just a simple {@link DynamicCircleEntity} that can move around the
 * {@link com.github.hanyaeger.api.scenes.DynamicScene}.
 * <p>
 * The interface {@link Collider} is used to registers collisions with a {@link Rocket}.
 * <p>
 * The interface {@link MouseMovedListener} is used to follow the mouse pointer. The event handler
 * {@link MouseMovedListener#onMouseMoved(Coordinate2D)} is the used to change the appearance of the cursor
 * and set the anchor location of this Entity based on the cursor location. The {@link ControlArea}, which
 * is passed through the constructor is used to decide when the mouse moved should be listened to. Only when the
 * mouse pointer is within the {@link ControlArea}, the spaceship should follow it.
 */
public class SpaceShip extends DynamicCircleEntity implements MouseMovedListener, Collider {

    private static final double RADIUS = 20;
    private ControlArea controlArea;

    public SpaceShip(final Coordinate2D location, final ControlArea controlArea) {
        super(location);
        this.controlArea = controlArea;
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.WHITE);
        setRadius(RADIUS);
    }

    @Override
    public void onMouseMoved(final Coordinate2D coordinate2D) {
        if (coordinate2D.getX() > RADIUS + controlArea.getBoundingBox().getMinX() &&
                coordinate2D.getX() < controlArea.getBoundingBox().getMaxX() - RADIUS &&
                coordinate2D.getY() > RADIUS + controlArea.getBoundingBox().getMinY() &&
                coordinate2D.getY() < controlArea.getBoundingBox().getMaxY() - RADIUS) {
            setCursor(Cursor.NONE);

            setAnchorLocation(coordinate2D);
        } else if (getCursor() == null || getCursor().equals(Cursor.NONE)) {
            setCursor(Cursor.DEFAULT);
        }
    }
}
