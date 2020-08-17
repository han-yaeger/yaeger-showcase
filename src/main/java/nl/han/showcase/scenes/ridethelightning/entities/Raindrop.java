package nl.han.showcase.scenes.ridethelightning.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.DynamicEllipseEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class Raindrop extends DynamicEllipseEntity implements SceneBorderCrossingWatcher {

    public Raindrop(final Location initialPosition, final double speed, final double width, final double height) {
        super(initialPosition);
        setRadiusX(width);
        setRadiusY(height);
        setOpacity(0.4);
        setFill( Color.rgb(10,10,40));
        setStrokeWidth(0);
        setMotionTo(speed, Direction.DOWN.getValue());
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        remove();
    }
}
