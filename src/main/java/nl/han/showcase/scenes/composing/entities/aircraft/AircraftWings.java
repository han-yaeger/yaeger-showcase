package nl.han.showcase.scenes.composing.entities.aircraft;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.EllipseEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class AircraftWings extends EllipseEntity {

    public AircraftWings(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadiusX(100);
        setRadiusY(10);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(1);
        setFill(YaegerShowCase.HAN_RED);
    }
}
