package nl.han.showcase.scenes.time.timers;

import com.github.hanyaeger.api.Timer;
import nl.han.showcase.scenes.time.Time;

public class SceneMinuteTimer extends Timer {

    private Time scene;

    public SceneMinuteTimer(final Time scene) {
        super(1000);
        this.scene = scene;
    }

    @Override
    public void onAnimationUpdate(final long timestamp) {
        scene.update();
    }
}
