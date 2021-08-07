package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class CollidingDynamicCircle extends DynamicCircleEntity implements SceneBorderTouchingWatcher, Collider, Collided {

    public CollidingDynamicCircle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(30);
        setOpacity(0.3);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(4);
        setMotion(6, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        changeDirection(180);
    }
}
