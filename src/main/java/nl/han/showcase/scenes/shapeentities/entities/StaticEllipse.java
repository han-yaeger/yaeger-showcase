package nl.han.showcase.scenes.shapeentities.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.EllipseEntity;
import javafx.scene.paint.Color;

public class StaticEllipse extends EllipseEntity {

    public StaticEllipse(Location initialPosition) {
        super(initialPosition);
        setRadiusX(20);
        setRadiusY(30);
        setFill(Color.LIGHTSLATEGRAY);
        setStrokeColor(Color.DARKGREEN);
        setStrokeWidth(3);
    }
}
