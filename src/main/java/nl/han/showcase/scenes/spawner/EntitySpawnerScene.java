package nl.han.showcase.scenes.spawner;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.scenes.EntitySpawnerContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.spawner.entities.spawners.RainSpawner;

public class EntitySpawnerScene extends ShowCaseScene implements EntitySpawnerContainer {

    private YaegerShowCase showCase;

    public EntitySpawnerScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/night-city.jpg");
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(showCase, new Location(20, getHeight() - 30));
        addEntity(backButton);
    }

    @Override
    public YaegerShowCase getShowCase() {
        return showCase;
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new RainSpawner(getWidth(), 2, 4, 1, 2));
        addEntitySpawner(new RainSpawner(getWidth(), 2, 10, 2, 4));
    }
}
