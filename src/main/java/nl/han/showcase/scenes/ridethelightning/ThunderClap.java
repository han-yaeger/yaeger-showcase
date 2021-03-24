package nl.han.showcase.scenes.ridethelightning;

import com.github.hanyaeger.api.engine.media.audio.SoundClip;
import com.github.hanyaeger.api.engine.scenes.YaegerScene;

import java.util.Random;

public class ThunderClap {

    private final String audioClip;
    private final YaegerScene scene;
    private final Random random;

    private boolean inProgress = true;
    private boolean flashOn = false;
    private long startTime = 0;
    private long maxAge;
    private boolean clapPlayed = false;
    private final long timeBeforeClap;


    public ThunderClap(final String audioClip, final YaegerScene scene) {
        this.audioClip = audioClip;
        this.scene = scene;

        this.random = new Random();
        this.timeBeforeClap = new Random().nextInt(3);
    }

    public void execute(final long timestamp) {
        if (startTime == 0) {
            startTime = timestamp;
            maxAge = random.nextInt(3000) + 2000;
        }

        performFlash(timestamp);
        playThunderClap(timestamp);
    }

    private void performFlash(final long timeStamp) {
        if (maxAge < 0) {
            inProgress = false;
            return;
        }

        if (!flashOn & random.nextInt(10) > 8) {
            scene.setBrightness(0.4 + random.nextInt(5) / 10);
        } else if (random.nextInt(10) > 4) {
            scene.setBrightness(0);
        }

        maxAge--;
    }

    /**
     * Play the thunderclap audio file, but play it only once and after the {@link #timeBeforeClap}
     * has passed.
     *
     * @param timestamp A timestamp of the current time.
     */
    private void playThunderClap(final long timestamp) {
        if (!clapPlayed && (timestamp - startTime) >= timeBeforeClap) {
            new SoundClip(audioClip).play();
            clapPlayed = true;
        }
    }

    public boolean isInProgress() {
        return inProgress;
    }
}
