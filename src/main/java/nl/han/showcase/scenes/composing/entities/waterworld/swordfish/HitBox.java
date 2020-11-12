package nl.han.showcase.scenes.composing.entities.waterworld.swordfish;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

/**
 * The Hitbox to be used in the composition is just a simple static {@link RectangleEntity}
 * that implements {@link AABBCollider}.
 */
public class HitBox extends RectangleEntity implements AABBCollider {

    public HitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        // The width and height are about the same size as the sword of the swordfish.
        setWidth(60);
        setHeight(2);
        // We set the color to Transparent, so the hit box will not be visible.
        setFill(Color.TRANSPARENT);
    }
}
