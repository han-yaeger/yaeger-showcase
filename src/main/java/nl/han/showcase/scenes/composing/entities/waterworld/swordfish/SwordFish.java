package nl.han.showcase.scenes.composing.entities.waterworld.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

/**
 * Contrary to the Tutorial, The SwordFish is now created as a composition, through the use of a
 * {@link DynamicCompositeEntity}. This composition consists of two Entities: The Swordfish and a hit box that
 * is placed directly over the sword of The Swordfish
 */
public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public SwordFish(final Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(4, Direction.LEFT);
    }

    @Override
    protected void setupEntities() {
        var swordFishSprite = new SwordfishSprite(new Coordinate2D(0, 0));
        addEntity(swordFishSprite);

        // The hit box that is used for collision detection.
        var hitBox = new HitBox(new Coordinate2D(0, 40));
        addEntity(hitBox);
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
    }
}
