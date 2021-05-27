package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class ControlArea extends RectangleEntity {

    public ControlArea(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setWidth(size.width());
        setHeight(size.height());
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1D);
    }
}
