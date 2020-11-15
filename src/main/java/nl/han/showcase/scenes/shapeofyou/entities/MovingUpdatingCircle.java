package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

/**
 * By extending the {@link UpdatingCircle} more behaviour can be added. In this case we give the {@link MovingUpdatingCircle}
 * movement, make it a {@link SceneBorderTouchingWatcher}. Moreover, we use the {@link com.github.hanyaeger.api.engine.UpdateExposer#explicitUpdate(long)}
 * to not only change the {@code radius), but also the {@code fill}.
 */
public class MovingUpdatingCircle extends UpdatingCircle implements SceneBorderTouchingWatcher {

    private static final double RADIUS_DELTA = 2;

    public MovingUpdatingCircle(final Coordinate2D initialLocation) {
        super(initialLocation);

        setMotion(2, Direction.RIGHT);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        super.explicitUpdate(timestamp);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }

    /**
     * To give this {@link MovingUpdatingCircle} a different speed in which the radius increases and decreases,
     * we overwrite this method to return a different {@link #RADIUS_DELTA}.
     *
     * @return The value with which the radius should inc- or decremented.
     */
    @Override
    protected double getRadiusIncrement() {
        return RADIUS_DELTA;
    }
}
