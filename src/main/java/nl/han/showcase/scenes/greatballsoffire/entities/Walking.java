package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class Walking extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {

    private int row = 0;

    public Walking(final Coordinate2D initialLocation) {
        super("entities/scottpilgrim_multiple.png", initialLocation, 2, 8);
        setAutoCycle(100, row);
        setMotion(7, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180D);
        row = (row + 1) % 2;
        setAutoCycleRow(row);
    }
}
