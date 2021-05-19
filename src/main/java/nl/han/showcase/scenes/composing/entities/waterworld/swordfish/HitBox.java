package nl.han.showcase.scenes.composing.entities.waterworld.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

/**
 * The Hitbox to be used in the composition is just a simple static {@link RectangleEntity}
 * that implements {@link Collider}.
 */
public class HitBox extends RectangleEntity implements Collider {

    public HitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        // The width and height are about the same size as the sword of the swordfish.
        setWidth(60);
        setHeight(2);
        // We set the color to Transparent, so the hit box will not be visible.
        setFill(Color.TRANSPARENT);
    }
}
