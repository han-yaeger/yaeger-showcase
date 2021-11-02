package nl.han.showcase.scenes.scrollingstones.entities.game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Zombie extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider {

    private int row = 0;

    public Zombie(final Coordinate2D initialLocation) {
        super("entities/zombie-spritemap.png", initialLocation, 2, 12);
        setAutoCycle(100, row);
        setMotion(1.6, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180D);
        row = (row + 1) % 2;
        setAutoCycleRow(row);
    }
}
