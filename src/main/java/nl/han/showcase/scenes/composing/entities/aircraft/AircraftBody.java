package nl.han.showcase.scenes.composing.entities.aircraft;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.ellipse.EllipseEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class AircraftBody extends EllipseEntity {

    public AircraftBody(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadiusX(20);
        setRadiusY(70);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(1);
        setFill(YaegerShowCase.HAN_RED);
    }
}
