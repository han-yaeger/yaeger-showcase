package nl.han.showcase.scenes.roadsgoeveron.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.showcase.scenes.roadsgoeveron.entities.SpawnedTextEntity;

public class TextSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    public TextSpawner(final long intervalInMs, final double sceneWidth, final double sceneHeight) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new SpawnedTextEntity(new Coordinate2D(sceneWidth - 10, sceneHeight)));
    }
}
