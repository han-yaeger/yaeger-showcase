package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.EllipseEntity;
import javafx.scene.paint.Color;

public class StaticEllipse extends EllipseEntity {

    public StaticEllipse(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadiusX(20);
        setRadiusY(30);
        setFill(Color.LIGHTSLATEGRAY);
        setStrokeColor(Color.DARKGREEN);
        setStrokeWidth(3);
    }
}
