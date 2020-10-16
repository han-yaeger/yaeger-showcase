package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class BlueBallBouncing extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {

    public BlueBallBouncing(final Coordinate2D location) {
        super("entities/ball-blue.png", location, new Size(30, 30), 0);
        setMotionTo(4, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirectionBy(180);
    }
}
