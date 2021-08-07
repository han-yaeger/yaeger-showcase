package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.EllipseEntity;
import nl.han.showcase.scenes.shapeofyou.ShapeOfYouScene;

public class StaticEllipse extends EllipseEntity {

    public StaticEllipse(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadiusX(20);
        setRadiusY(50);
        setFill(ShapeOfYouScene.YELLOW);
        setStrokeColor(ShapeOfYouScene.ORANGE);
        setStrokeWidth(3);
    }
}
