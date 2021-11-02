package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

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
    public void onCollision(final List<Collider> collidingObject) {
        changeDirection(180);
    }
}
