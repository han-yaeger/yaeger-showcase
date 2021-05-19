package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class RectangularFloor extends RectangleEntity implements Collider {

    public RectangularFloor(final Coordinate2D initialPosition) {
        super(initialPosition);

        setHeight(20);
        setWidth(140);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }
}
