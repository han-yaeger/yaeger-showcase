package nl.han.showcase.scenes.distance;

import com.github.hanyaeger.api.engine.entities.EntitySpawner;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import nl.han.showcase.scenes.distance.entities.Rocket;

import java.util.Random;

public class RocketSpawner extends EntitySpawner {

    private final Coordinate2D location;
    private double direction = Direction.UP.getValue();

    public RocketSpawner(Coordinate2D location) {
        super(500);
        this.location = location;
    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextBoolean()) {
            spawn(new Rocket(location, direction));
        }
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
