package nl.han.showcase.scenes.shapeentities.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class DynamicRectangle extends DynamicRectangleEntity implements SceneBorderTouchingWatcher {

    public DynamicRectangle(Location initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setOpacity(0.8);
        setFill(Color.PALEGREEN);
        setStrokeColor(Color.SPRINGGREEN);
        setStrokeWidth(4);
        setMotionTo(5, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirectionBy(180);
    }
}
