package nl.han.showcase.scenes.roadsgoeveron.entities.timers;

import com.github.hanyaeger.api.Timer;
import nl.han.showcase.scenes.roadsgoeveron.entities.TimedDynamicTextEntity;

public class TimedDynamicTextTimer extends Timer {

    private TimedDynamicTextEntity timedDynamicTextEntity;

    /**
     * Create a new instance of {@link Timer} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milleseconds.
     */
    public TimedDynamicTextTimer(final TimedDynamicTextEntity timedDynamicTextEntity, int intervalInMs) {
        super(intervalInMs);
        this.timedDynamicTextEntity = timedDynamicTextEntity;
    }

    @Override
    public void onAnimationUpdate(final long timestamp) {
        timedDynamicTextEntity.nextLine();
    }
}
