package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class BlueBallCircling extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

    public BlueBallCircling(final Coordinate2D location) {
        super("entities/ball-blue.png", location, new Size(30, 30), 0);
        setMotionTo(8, Direction.RIGHT.getValue());

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border.equals(SceneBorder.RIGHT)) {
            setAnchorLocationX(-30);
        }
    }
}
