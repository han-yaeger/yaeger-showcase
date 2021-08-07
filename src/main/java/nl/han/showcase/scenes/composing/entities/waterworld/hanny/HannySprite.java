package nl.han.showcase.scenes.composing.entities.waterworld.hanny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

/**
 * A simple {@link DynamicSpriteEntity} is used for Hanny. The frame-index is controlled from the enclosing
 * {@link com.github.hanyaeger.api.entities.CompositeEntity}.
 */
public class HannySprite extends DynamicSpriteEntity {

    public HannySprite(final Coordinate2D location) {
        super("entities/hanny.png", location, new Size(20, 40), 1, 2);
    }
}
