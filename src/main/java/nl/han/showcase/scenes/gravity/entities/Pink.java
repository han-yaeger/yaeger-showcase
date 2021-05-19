package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.sprite.DynamicSpriteEntity;

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
