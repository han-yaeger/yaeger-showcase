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
        super("entities/ball-green.png", location, new Size(20, 20));
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setMotion(2.5, 90D);
        setFrictionConstant(0.01);
        setRotationSpeed(-2);
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        setAnchorLocationY(collidingObject.getBoundingBox().getMinY());

        System.out.println(getSpeed());

        if (getSpeedInDirection(Direction.DOWN) < 1) {
            nullifySpeedInDirection(Direction.DOWN);
            setRotationSpeed(0);
        } else if (getSpeedInDirection(Direction.DOWN) < 2) {
            incrementSpeed(-0.6 * getSpeed());
        } else if (getSpeedInDirection(Direction.DOWN) < 4) {
            incrementSpeed(-0.5 * getSpeed());
        } else if (getSpeedInDirection(Direction.DOWN) < 6) {
            incrementSpeed(-0.4 * getSpeed());
        } else if (getSpeedInDirection(Direction.DOWN) < 8) {
            incrementSpeed(-0.3 * getSpeed());
        }

        invertSpeedInDirection(Direction.DOWN);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        nullifySpeedInDirection(Direction.RIGHT);
    }
}
