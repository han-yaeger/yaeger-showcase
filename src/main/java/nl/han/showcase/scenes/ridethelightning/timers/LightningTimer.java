package nl.han.showcase.scenes.ridethelightning.timers;

import com.github.hanyaeger.api.engine.Timer;
import com.github.hanyaeger.api.engine.media.audio.SoundClip;

import java.util.List;
import java.util.Random;

public class LightningTimer extends Timer {

    private static final long INTERVAL = 2000;
    private static final String THUNDER1 = "audio/thunder1.mp3";
    private static final String THUNDER2 = "audio/thunder2.mp3";
    private static final String THUNDER3 = "audio/thunder3.mp3";
    private List<String> thunderList = List.of(THUNDER1, THUNDER2, THUNDER3);

    public LightningTimer() {
        super(INTERVAL);
    }

    @Override
    public void onAnimationUpdate(long timestamp) {

        if (new Random().nextInt(10) > 5) {
            new SoundClip(thunderList.get(new Random().nextInt(2))).play();
        }
    }
}
