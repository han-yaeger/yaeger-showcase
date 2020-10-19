package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

/**
 * By extending the {@link UpdatingCircle} more behaviour can be added. In this case we give the {@link CollidingUpdatingCircle}
 * movement, make it a {@link SceneBorderTouchingWatcher}. Moreover, we use the {@link com.github.hanyaeger.api.engine.UpdateExposer#explicitUpdate(long)}
 * to not only change the {@code radius), but also the {@code fill}.
 */
public class CollidingUpdatingCircle extends UpdatingCircle implements SceneBorderTouchingWatcher {

    public CollidingUpdatingCircle(final Coordinate2D initialLocation) {
        super(initialLocation);

        setMotionTo(0.1, Direction.RIGHT.getValue());
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        super.explicitUpdate(timestamp);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirectionBy(180);
    }
}
