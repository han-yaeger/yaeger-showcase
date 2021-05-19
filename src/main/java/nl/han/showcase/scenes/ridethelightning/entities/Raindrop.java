package nl.han.showcase.scenes.ridethelightning.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.ellipse.DynamicEllipseEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class Raindrop extends DynamicEllipseEntity implements SceneBorderCrossingWatcher {

    public Raindrop(final Coordinate2D initialPosition, final double speed, final double width, final double height) {
        super(initialPosition);
        setRadiusX(width);
        setRadiusY(height);
        setOpacity(0.4);
        setFill(Color.rgb(10, 10, 40));
        setStrokeWidth(0);
        setMotion(speed, Direction.DOWN);
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        remove();
    }
}
