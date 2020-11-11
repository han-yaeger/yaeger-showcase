package nl.han.showcase.scenes.composing.entities.car;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;

public class Body extends RectangleEntity {

    public Body(Coordinate2D initialPosition) {
        super(initialPosition);
        setHeight(40);
        setWidth(210);
        setFill(Car.BODY_COLOR);
    }
}
