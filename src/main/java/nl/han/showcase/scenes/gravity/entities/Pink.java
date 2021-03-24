package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;

public class Pink extends DynamicSpriteEntity implements Newtonian, Collided {

    public Pink(final Coordinate2D location) {
        super("entities/ball-pink.png", location, new Size(60, 60));
        setRotationSpeed(7);
    }


    @Override
    public void onCollision(final Collider collidingObject) {
        setDirection(Direction.UP);
    }
}
