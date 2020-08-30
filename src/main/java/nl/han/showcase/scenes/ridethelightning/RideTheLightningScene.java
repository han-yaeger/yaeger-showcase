package nl.han.showcase.scenes.ridethelightning;

import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.scenes.EntitySpawnerContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.ridethelightning.entities.spawners.RainSpawner;
import nl.han.showcase.scenes.ridethelightning.timers.LightningTimer;

public class RideTheLightningScene extends ShowCaseScene implements EntitySpawnerContainer, TimerContainer {

    private YaegerShowCase showCase;

    public RideTheLightningScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/raindrops.mp3");
        setBackgroundImage("backgrounds/night-city.jpg");
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(showCase, new Coordinate2D(20, getHeight() - 30));
        addEntity(backButton);
    }

    @Override
    public YaegerShowCase getShowCase() {
        return showCase;
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new RainSpawner(getWidth(), 0.5, 12, 1, 2));
        addEntitySpawner(new RainSpawner(getWidth(), 0.5, 24, 1, 4));
        addEntitySpawner(new RainSpawner(getWidth(), 0.5, 36, 1, 8));
        addEntitySpawner(new RainSpawner(getWidth(), 0.5, 48, 1, 12));
    }

    @Override
    public void setupTimers() {
        addTimer(new LightningTimer(this));
    }
}
