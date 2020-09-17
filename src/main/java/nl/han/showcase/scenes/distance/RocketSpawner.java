package nl.han.showcase.scenes.distance;

import com.github.hanyaeger.api.engine.entities.EntitySpawner;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import nl.han.showcase.scenes.distance.entities.Rocket;

import java.util.Random;

/**
 * As its name suggests, the {@link RocketSpawner} is an {@link EntitySpawner}
 * that is responsible for spawning the rockets.
 */
public class RocketSpawner extends EntitySpawner {

    private final Coordinate2D location;
    private double direction = Direction.UP.getValue();

    public RocketSpawner(Coordinate2D location) {
        super(500);
        this.location = location;
    }

    @Override
    protected void spawnEntities() {
        // We use a rondom boolean value to decide if we spawn a new rocket.
        if (new Random().nextBoolean()) {
            spawn(new Rocket(location, direction));
        }
    }

    /**
     * The direction is used to decide in which direction the newly Spawned Entity should travel.
     * By calling this setter, the new direction is set, which is then passed to the new {@link Rocket},
     * through its constructor.
     *
     * @param direction The direction in which the next {@link Rocket} should travel.
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }
}
