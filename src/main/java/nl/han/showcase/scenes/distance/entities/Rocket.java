package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.circle.DynamicCircleEntity;
import javafx.scene.paint.Color;

/**
 * A simple {@link DynamicCircleEntity} that needs to know when it collides with an
 * {@link Collider}, so it can remove itself.
 */
public class Rocket extends DynamicCircleEntity implements Collided {

    public Rocket(final Coordinate2D initialPosition, final double direction) {
        super(initialPosition);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setStrokeWidth(1);
        setStrokeColor(Color.YELLOW);
        setFill(Color.ORANGE);
        setMotion(8, direction);
        setRadius(4);
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        remove();
    }
}
