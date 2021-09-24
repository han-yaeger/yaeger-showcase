package nl.han.showcase.scenes.scrolling.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Bat extends DynamicSpriteEntity {

    private int row = 1;

    public Bat(final Coordinate2D initialLocation) {
        super("entities/bat-spritemap.png", initialLocation, 2, 10);
        setAutoCycle(100, row);
        setMotion(3, Direction.RIGHT);
    }

//    @Override
//    public void notifyBoundaryTouching(final SceneBorder border) {
//        changeDirection(180D);
//        row = (row + 1) % 2;
//        setAutoCycleRow(row);
//    }
}
