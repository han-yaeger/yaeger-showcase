package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.sprite.DynamicSpriteEntity;

public class Blue extends DynamicSpriteEntity implements Newtonian, Collided {

    public Blue(final Coordinate2D location) {
        super("entities/ball-blue.png", location, new Size(30, 30));
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        setDirection(Direction.UP);
    }
}
