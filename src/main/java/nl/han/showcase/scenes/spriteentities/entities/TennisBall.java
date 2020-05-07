package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class TennisBall extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {

    public TennisBall(Location location) {
        super("entities/tennisball.png", location, new Size(30, 30), 0);
        setMotionTo(4, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirectionBy(180);
    }
}
