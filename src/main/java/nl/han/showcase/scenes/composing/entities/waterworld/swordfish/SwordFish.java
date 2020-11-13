package nl.han.showcase.scenes.composing.entities.waterworld.swordfish;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

/**
 * Contrary to the Tutorial, The SwordFish is now created as a composition, through the use of a
 * {@link DynamicCompositeEntity}. This composition consists of two Entities: The Swordfish and a hit box that
 * is placed directly over the sword of The Swordfish
 */
public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public SwordFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(4, Direction.LEFT.getValue());
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
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
    }
}
