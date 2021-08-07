package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.scenes.shapeofyou.ShapeOfYouScene;

public class DynamicRectangle extends DynamicRectangleEntity implements SceneBorderTouchingWatcher {

    public DynamicRectangle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setOpacity(0.8);
        setFill(ShapeOfYouScene.YELLOW);
        setStrokeColor(ShapeOfYouScene.ORANGE);
        setStrokeWidth(4);
        setMotion(5, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }
}
