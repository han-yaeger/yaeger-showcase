package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

/**
 * The Bouncing Blue Ball is a {@link DynamicSpriteEntity} that uses a {@code png} image file
 * in its original size. This way it is possible to use the constructor that requires only the
 * {@code resource} and the {@code location}.
 * <p>
 * By implementing the interface {@link SceneBorderTouchingWatcher} the Bouncing Blue Ball gets
 * notified if it touches the border of the scene, after which it calls
 * {@link com.github.hanyaeger.api.engine.entities.entity.motion.Movable#changeDirection(double)}.
 */
public class BlueBallBouncing extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {

    public BlueBallBouncing(final Coordinate2D location) {
        super("entities/ball-blue-small.png", location);
        setMotion(4, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }
}
