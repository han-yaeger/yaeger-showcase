package nl.han.showcase.scenes.ridethelightning;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.TimerContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.ridethelightning.entities.spawners.RainSpawner;
import nl.han.showcase.scenes.ridethelightning.timers.LightningTimer;

public class RideTheLightningScene extends ShowCaseScene implements EntitySpawnerContainer, TimerContainer {

    public RideTheLightningScene(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/raindrops.mp3");
        setBackgroundImage("backgrounds/night.jpg");
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
