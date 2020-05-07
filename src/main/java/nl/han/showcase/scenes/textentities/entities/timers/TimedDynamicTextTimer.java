package nl.han.showcase.scenes.textentities.entities.timers;

import com.github.hanyaeger.api.engine.Timer;
import nl.han.showcase.scenes.textentities.entities.TimedDynamicTextEntity;

public class TimedDynamicTextTimer extends Timer {

    private TimedDynamicTextEntity timedDynamicTextEntity;

    /**
     * Create a new instance of {@link Timer} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milleseconds.
     */
    public TimedDynamicTextTimer(TimedDynamicTextEntity timedDynamicTextEntity, int intervalInMs) {
        super(intervalInMs);
        this.timedDynamicTextEntity = timedDynamicTextEntity;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        timedDynamicTextEntity.nextLine();
    }

}
