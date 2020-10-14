package nl.han.showcase.scenes.composing.entities.wheel;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import nl.han.showcase.YaegerShowCase;

public class Spoke extends RectangleEntity {

    public Spoke(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(60);
        setHeight(1);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeWidth(0);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
