package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

public class ButtonBackground extends RectangleEntity {

    public ButtonBackground(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition);
        setWidth(size.getWidth());
        setHeight(size.getHeight());
        setFill(Color.BLACK);
        setStrokeWidth(0);
    }
}
