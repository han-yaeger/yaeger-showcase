package nl.han.showcase.scenes.ridethelightning.entities.spawners;

import com.github.hanyaeger.api.engine.entities.EntitySpawner;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import nl.han.showcase.scenes.ridethelightning.entities.Raindrop;

import java.util.Random;

public class RainSpawner extends EntitySpawner {

    private final double worldWidth;
    private final double raindropWidth;
    private final double raindropHeight;
    private final int maxSpeed;

    /**
     * Create a new instance of {@link EntitySpawner} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milliseconds.
     */
    public RainSpawner(final double worldWidth, final double raindropWidth, final double raindropHeight, final long intervalInMs, final int maxSpeed) {
        super(intervalInMs);
        this.worldWidth = worldWidth;
        this.raindropWidth = raindropWidth;
        this.raindropHeight = raindropHeight;
        this.maxSpeed = maxSpeed;
    }

    @Override
    protected void spawnEntities() {
        var raindrop = new Raindrop(generateRandomPosition(), generateRandomSpeed(), raindropWidth, raindropHeight);

        spawn(raindrop);
    }

    private int generateRandomSpeed() {
        return new Random().nextInt(maxSpeed) + 8;
    }

    private Coordinate2D generateRandomPosition() {
        int x = new Random().nextInt((int) Math.round(worldWidth));

        return new Coordinate2D(x, 0);
    }
}
