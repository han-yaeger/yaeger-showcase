package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import nl.han.showcase.YaegerShowCase;

public class AntiAircraftBase extends DynamicCircleEntity {

    public AntiAircraftBase(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(60);
        setFill(YaegerShowCase.HAN_RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
