package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.engine.UpdateExposer;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.distance.RocketSpawner;

public class AnitAircraftLauncer extends DynamicRectangleEntity implements UpdateExposer {

    private final SpaceShip spaceShip;
    private final RocketSpawner rocketSpawner;

    public AnitAircraftLauncer(Coordinate2D initialPosition, SpaceShip spaceShip, RocketSpawner rocketSpawner) {
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
