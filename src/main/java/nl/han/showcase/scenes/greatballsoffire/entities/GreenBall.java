package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class GreenBall extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider, Collided {


    public GreenBall(final Coordinate2D location, double speed, double direction) {
        super("entities/ball-green.png", location, new Size(20, 20));
        setMotion(speed, direction);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        changeDirection(180);
    }
}
