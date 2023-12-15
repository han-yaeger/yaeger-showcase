package com.github.hanyaeger.showcase.scenes.burnthewitch.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.showcase.scenes.burnthewitch.BurnTheWitchScene;
import javafx.scene.paint.Color;

/**
 * A transparent rectangle that can be used as the floor withing the
 * {@link BurnTheWitchScene}. Its main feature is it being a {@link Collider},
 * meaning all instances of {@link com.github.hanyaeger.api.entities.Collided} can use it as a reference point for
 * stopping the gravitational pull.
 */
public abstract class WitchCollidingBox extends RectangleEntity implements Collider {

    public static final double OPACITY = 0;
    private static final Color COLOR = Color.RED;

    public WitchCollidingBox(final Coordinate2D initialLocation, final Size size) {
        super(initialLocation, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);

        // The color is set to ensure it stands out while it is not transparant. The reason
        // make it visible is that its much easier during development.
        setFill(COLOR);

        // The Opacity is used to make this floor transparant
        setOpacity(OPACITY);
    }
}
