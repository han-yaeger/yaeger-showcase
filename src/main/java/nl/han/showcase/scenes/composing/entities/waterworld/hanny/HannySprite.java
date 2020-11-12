package nl.han.showcase.scenes.composing.entities.waterworld.hanny;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;

/**
 * A simple {@link DynamicSpriteEntity} is used for Hanny. The frame-index is controlled from the enclosing
 * {@link com.github.hanyaeger.api.engine.entities.entity.CompositeEntity}.
 */
public class HannySprite extends DynamicSpriteEntity {

    public HannySprite(Coordinate2D location) {
        super("entities/hanny.png", location, new Size(20, 40), 2);
    }
}
