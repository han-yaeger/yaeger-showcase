package nl.han.showcase.scenes.ridethelightning.timers;

import com.github.hanyaeger.api.engine.Timer;
import com.github.hanyaeger.api.engine.scenes.YaegerScene;
import nl.han.showcase.scenes.ridethelightning.ThunderClap;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LightningTimer extends Timer {

    private static final long THUNDER_INTERVAL = 5000 * 1_000_000;
    private final YaegerScene scene;

    private long prevTime = 0;

    private static final String THUNDER1 = "audio/thunder1.mp3";
    private static final String THUNDER2 = "audio/thunder2.mp3";
    private static final String THUNDER3 = "audio/thunder3.mp3";
    private List<String> thunderList = List.of(THUNDER1, THUNDER2, THUNDER3);
    private Set<ThunderClap> thunderClaps = new HashSet<>();

    public LightningTimer(final YaegerScene scene) {
        super(2);
        this.scene = scene;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {

        if (prevTime == 0) {
            prevTime = timestamp;
        }

        callThunderClaps(timestamp);
        removeFinishedThunderClaps();

        if ((timestamp - prevTime) >= THUNDER_INTERVAL) {
            prevTime = timestamp;
            initiateNewThunderClap();
        }
    }

    private void callThunderClaps(long timestamp) {
        thunderClaps.forEach(thunderClap -> thunderClap.execute(timestamp));
    }

    private void initiateNewThunderClap() {
        if (new Random().nextBoolean()) {
            thunderClaps.add(new ThunderClap(thunderList.get(new Random().nextInt(2)), scene));
        }
    }

    private void removeFinishedThunderClaps() {
        var filteredSet = thunderClaps.stream().filter(thunderClap -> thunderClap.isInProgress()).collect(Collectors.toSet());
        thunderClaps = filteredSet;
    }
}
