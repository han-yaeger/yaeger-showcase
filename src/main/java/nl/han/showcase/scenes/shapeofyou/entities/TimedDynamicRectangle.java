package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.DynamicRectangleEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.shapeofyou.entities.timers.TimedDynamicRectangleTimer;

/**
 * A {@link DynamicRectangleEntity} that uses a {@link com.github.hanyaeger.api.engine.Timer} to change the arcWidth
 * and arcHeight of the rectangle.
 */
public class TimedDynamicRectangle extends DynamicRectangleEntity implements TimerContainer, SceneBorderTouchingWatcher {

    private static final double ARC_MIN = 0;
    private static final double ARC_MAX = 110;
    private double currentArc = 0;
    private boolean decreasing = false;

    public TimedDynamicRectangle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.BLACK);
        setStrokeWidth(4);
        setArc();
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirection(180);
    }

    @Override
    public void setupTimers() {
        addTimer(new TimedDynamicRectangleTimer(this, 10));
    }

    public void setArc() {
        if (!decreasing && currentArc < ARC_MAX - 1) {
            currentArc++;
        } else if (decreasing && currentArc > ARC_MIN + 1) {
            currentArc--;
        } else {
            decreasing = !decreasing;
        }

        setArcHeight(currentArc);
        setArcWidth(currentArc);
    }
}
