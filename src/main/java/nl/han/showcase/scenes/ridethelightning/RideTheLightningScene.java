package nl.han.showcase.scenes.ridethelightning;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.distance.entities.DistanceText;
import nl.han.showcase.scenes.ridethelightning.entities.VolumeText;
import nl.han.showcase.scenes.ridethelightning.entities.spawners.RainSpawner;
import nl.han.showcase.scenes.ridethelightning.timers.LightningTimer;

import java.util.Set;

public class RideTheLightningScene extends ShowCaseScene implements EntitySpawnerContainer, TimerContainer {

    private static final double BACKGROUND_AUDIO_DELTA = 0.01D;

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
    public void setupEntities() {
        super.setupEntities();

        var volumeText = new VolumeText(new Coordinate2D(getWidth() - 20, 80), this);
        volumeText.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(volumeText);
    }

    @Override
    public void setupTimers() {
        addTimer(new LightningTimer(this));
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        super.onPressedKeysChange(pressedKeys);

        if (pressedKeys.contains(KeyCode.M)) {
            setBackgroundAudioVolume(getBackgroundAudioVolume() + BACKGROUND_AUDIO_DELTA);
        }

        if (pressedKeys.contains(KeyCode.N)) {
            setBackgroundAudioVolume(getBackgroundAudioVolume() - BACKGROUND_AUDIO_DELTA);
        }
    }
}
