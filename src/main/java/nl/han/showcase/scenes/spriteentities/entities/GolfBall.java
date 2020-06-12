package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.ContinuousRotatable;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class GolfBall extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, ContinuousRotatable, AABBCollider, AABBCollided {


    public GolfBall(Location location, double speed, double direction) {
        super("entities/golfball.png", location, new Size(20, 20), 0);
        setMotionTo(speed, direction);
        setRotationSpeed(2);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirectionBy(180);
    }

    @Override
    public void onCollision(AABBCollider collidingObject) {
        changeDirectionBy(180);
    }
}
