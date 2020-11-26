package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

/**
 * THe {@link GroundCollider} is an invisible {@link RectangleEntity} that is used to notify the {@link GreenNewtonianBall}
 * to stop falling. By changing the {@link com.github.hanyaeger.api.engine.entities.entity.YaegerEntity#setOpacity(double)}
 * to a value bigger than 0, it can be made visible, which is convenient during creation of the {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}.
 */
public class GroundCollider extends RectangleEntity implements Collider {

    public GroundCollider(final Coordinate2D initialPosition) {
        super(initialPosition);
        setOpacity(0);
        setFill(Color.RED);
        setStrokeWidth(0);
        setHeight(10);
    }
}
