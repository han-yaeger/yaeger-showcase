package nl.han.showcase.scenes.composing.entities.car.wheel;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.circle.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class Tire extends CircleEntity {

    public Tire(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(30);
        setFill(Color.TRANSPARENT);
        setStrokeWidth(4);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
