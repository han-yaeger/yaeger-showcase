package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.DynamicEllipseEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class CollidingDynamicEllipse extends DynamicEllipseEntity implements SceneBorderTouchingWatcher, AABBCollided, AABBCollider {

    public CollidingDynamicEllipse(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadiusX(40);
        setRadiusY(10);
        setOpacity(0.8);
        setFill(Color.BLACK);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(4);
        setMotionTo(5, Direction.LEFT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirectionBy(180);
    }

    @Override
    public void onCollision(AABBCollider collidingObject) {
        changeDirectionBy(180);
    }
}
