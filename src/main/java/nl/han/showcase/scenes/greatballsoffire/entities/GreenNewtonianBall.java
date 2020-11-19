package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.ContinuousRotatable;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class GreenNewtonianBall extends DynamicSpriteEntity implements Newtonian, Collided {

    public GreenNewtonianBall(final Coordinate2D location) {
        super("entities/ball-green.png", location, new Size(20, 20), 0);
        setRotationSpeed(2);
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        setSpeed(0);
    }
}
