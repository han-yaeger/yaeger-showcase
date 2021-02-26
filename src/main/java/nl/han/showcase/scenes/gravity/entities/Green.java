package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.*;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class Green extends DynamicSpriteEntity implements Newtonian, Collided, SceneBorderTouchingWatcher {

    public Green(final Coordinate2D location) {
        super("entities/ball-green.png", location, new Size(20, 20), 0);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        setAnchorLocationY(collidingObject.getBoundingBox().getMinY());
        nullifySpeedInDirection(Direction.DOWN);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
    }
}
