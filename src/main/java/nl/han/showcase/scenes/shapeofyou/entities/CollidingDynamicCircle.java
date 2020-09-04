package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;

public class CollidingDynamicCircle extends DynamicCircleEntity implements SceneBorderTouchingWatcher, AABBCollider, AABBCollided {

    public CollidingDynamicCircle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(30);
        setOpacity(0.3);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(4);
        setMotionTo(6, Direction.RIGHT.getValue());
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
