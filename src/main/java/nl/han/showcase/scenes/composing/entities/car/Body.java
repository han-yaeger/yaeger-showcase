package nl.han.showcase.scenes.composing.entities.car;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity;

public class Body extends RectangleEntity {

    public Body(final Coordinate2D initialPosition) {
        super(initialPosition);
        setHeight(40);
        setWidth(210);
        setFill(Car.BODY_COLOR);
    }
}
