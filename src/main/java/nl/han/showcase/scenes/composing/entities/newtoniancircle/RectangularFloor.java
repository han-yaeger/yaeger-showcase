package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class RectangularFloor extends RectangleEntity implements Collider {

    public RectangularFloor(Coordinate2D initialPosition) {
        super(initialPosition);

        setHeight(20);
        setWidth(140);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }
}
