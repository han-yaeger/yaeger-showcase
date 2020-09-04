package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class StaticRectangle extends RectangleEntity {

    public StaticRectangle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(6);
    }
}
