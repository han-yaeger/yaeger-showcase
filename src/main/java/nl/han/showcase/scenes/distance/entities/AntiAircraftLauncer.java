package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.engine.UpdateExposer;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.distance.RocketSpawner;

/**
 * Since the {@link AntiAircraftLauncer} should follow the {@link SpaceShip} in near realtime, it should
 * check the angle at each Game World update. This can be achieved by adding a timer, but that would require
 * much code for such a trivial Use Case. For this reason, it implements the {@link UpdateExposer} interface,
 * which provides an {@link UpdateExposer#explicitUpdate(long)} method, that is called on each Game World update.
 */
public class AntiAircraftLauncer extends DynamicRectangleEntity implements UpdateExposer {

    private final SpaceShip spaceShip;
    private final RocketSpawner rocketSpawner;

    public AntiAircraftLauncer(Coordinate2D initialPosition, SpaceShip spaceShip, RocketSpawner rocketSpawner) {
        super(initialPosition);
        this.spaceShip = spaceShip;
        this.rocketSpawner = rocketSpawner;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(YaegerShowCase.HAN_RED);
        setWidth(15);
        setHeight(220);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        var angle = angleTo(spaceShip);
        rocketSpawner.setDirection(angle);
        setRotate(angle);
    }
}
