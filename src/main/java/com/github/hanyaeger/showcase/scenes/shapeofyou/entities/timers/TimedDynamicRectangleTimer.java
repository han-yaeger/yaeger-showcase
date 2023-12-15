package com.github.hanyaeger.showcase.scenes.shapeofyou.entities.timers;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.showcase.scenes.shapeofyou.entities.TimedDynamicRectangle;

public class TimedDynamicRectangleTimer extends Timer {

    private TimedDynamicRectangle timedDynamicRectangleint;

    /**
     * Create a new instance of {@link Timer} for the given interval in milliseconds.
     *
     * @param intervalInMs The interval in milleseconds.
     */
    public TimedDynamicRectangleTimer(final TimedDynamicRectangle timedDynamicRectangleint, final int intervalInMs) {
        super(intervalInMs);
        this.timedDynamicRectangleint = timedDynamicRectangleint;
    }

    @Override
    public void onAnimationUpdate(final long timestamp) {
        timedDynamicRectangleint.setArc();
    }
}
