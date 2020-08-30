package nl.han.showcase.scenes.shapeentities.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class DynamicCircle extends DynamicCircleEntity implements SceneBorderTouchingWatcher {

    public DynamicCircle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(40);
        setOpacity(0.8);
        setFill(Color.STEELBLUE);
        setStrokeColor(Color.SADDLEBROWN);
        setStrokeWidth(4);
        setMotionTo(1, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirectionBy(180);
    }
}
