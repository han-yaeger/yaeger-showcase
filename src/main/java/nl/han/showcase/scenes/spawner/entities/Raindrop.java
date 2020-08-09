package nl.han.showcase.scenes.spawner.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.DynamicEllipseEntity;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class Raindrop extends DynamicEllipseEntity implements SceneBorderCrossingWatcher {

    public Raindrop(final Location initialPosition, final double speed, final double width, final double height) {
        super(initialPosition);
        setRadiusX(width);
        setRadiusY(height);
        setOpacity(0.4);
        setFill(Color.BLACK);
        setStrokeWidth(0);
        setMotionTo(speed, Direction.DOWN.getValue());
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        remove();
    }
}
