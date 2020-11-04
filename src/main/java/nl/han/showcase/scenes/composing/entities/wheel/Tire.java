package nl.han.showcase.scenes.composing.entities.wheel;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class Tire extends CircleEntity {

    public Tire(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(30);
        setFill(Color.TRANSPARENT);
        setStrokeWidth(4);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
