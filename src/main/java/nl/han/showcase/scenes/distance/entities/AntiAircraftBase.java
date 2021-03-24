package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import nl.han.showcase.YaegerShowCase;

/**
 * A trivial {@link CircleEntity} that is used as the base of the AntiAircraft launcher.
 */
public class AntiAircraftBase extends CircleEntity {

    public AntiAircraftBase(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(60);
        setFill(YaegerShowCase.HAN_RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
