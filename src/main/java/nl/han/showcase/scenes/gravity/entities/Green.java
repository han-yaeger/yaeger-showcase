package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Green extends DynamicSpriteEntity implements Newtonian, Collided, SceneBorderTouchingWatcher {

    public Green(final Coordinate2D location) {
        super("entities/ball-green.png", location, new Size(20, 20));
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setMotion(2.5, 90D);
        setFrictionConstant(0.01);
        setRotationSpeed(-2);
    }

    @Override
    public void onCollision(final List<Collider> collidingObject) {
        setAnchorLocationY(collidingObject.get(0).getBoundingBox().getMinY());

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
    public void notifyBoundaryTouching(final SceneBorder border) {
        nullifySpeedInDirection(Direction.RIGHT);
    }
}
