package nl.han.showcase.scenes.timers.timers;

import com.github.hanyaeger.api.engine.Timer;
import nl.han.showcase.scenes.timers.DynamicSceneWithTimer;

public class SceneMinuteTimer extends Timer {

    private DynamicSceneWithTimer scene;

    public SceneMinuteTimer(DynamicSceneWithTimer scene) {
        super(1000);
        this.scene = scene;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        scene.update();
    }

}