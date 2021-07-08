package nl.han.showcase.scenes.time.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;
import java.util.Random;

public class Clock extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

    private static final int ROTATION_SPEED_MAX = 6;
    private static final List<String> resources = List.of("entities/clock1.png",
            "entities/clock2.png",
            "entities/clock3.png",
            "entities/clock4.png",
            "entities/clock5.png",
            "entities/clock6.png",
            "entities/clock7.png",
            "entities/clock8.png");

    public Clock(Coordinate2D initialLocation) {
        super(resources.get(new Random().nextInt(resources.size())), initialLocation);
        setRotationSpeed(new Random().nextInt(ROTATION_SPEED_MAX));
        setMotion(new Random().nextInt(ROTATION_SPEED_MAX) + 2, Direction.DOWN);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        if (SceneBorder.BOTTOM.equals(border)) {
            remove();
        }
    }
}
