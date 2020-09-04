package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.ContinuousRotatable;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class GreenBall extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, ContinuousRotatable, AABBCollider, AABBCollided {


    public GreenBall(final Coordinate2D location, double speed, double direction) {
        super("entities/ball-green.png", location, new Size(20, 20), 0);
        setMotionTo(speed, direction);
        setRotationSpeed(2);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirectionBy(180);
    }

    @Override
    public void onCollision(final AABBCollider collidingObject) {
        changeDirectionBy(180);
    }
}
