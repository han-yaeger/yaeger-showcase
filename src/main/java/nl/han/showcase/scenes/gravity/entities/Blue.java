package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class Blue extends DynamicSpriteEntity implements Newtonian, Collided {

    public Blue(final Coordinate2D location) {
        super("entities/ball-blue.png", location, new Size(30, 30));
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        setDirection(Direction.UP);
    }
}
