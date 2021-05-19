package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.rectangle.DynamicRectangleEntity;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.distance.RocketSpawner;

/**
 * Since the {@link AntiAircraftLauncher} should follow the {@link SpaceShip} in near realtime, it should
 * check the angle at each Game World update. This can be achieved by adding a timer, but that would require
 * much code for such a trivial Use Case. For this reason, it implements the {@link UpdateExposer} interface,
 * which provides an {@link UpdateExposer#explicitUpdate(long)} method, that is called on each Game World update.
 */
public class AntiAircraftLauncher extends DynamicRectangleEntity implements UpdateExposer {

    private final SpaceShip spaceShip;
    private final RocketSpawner rocketSpawner;

    public AntiAircraftLauncher(final Coordinate2D initialPosition, final SpaceShip spaceShip, final RocketSpawner rocketSpawner) {
        super(initialPosition);
        this.spaceShip = spaceShip;
        this.rocketSpawner = rocketSpawner;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(YaegerShowCase.HAN_RED);
        setWidth(15);
        setHeight(220);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        var angle = angleTo(spaceShip);
        rocketSpawner.setDirection(angle);
        setRotate(angle);
    }
}
