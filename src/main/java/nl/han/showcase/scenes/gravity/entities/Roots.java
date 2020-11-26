package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

/**
 * A very simple {@link SpriteEntity} that is used for displaying the roots that can be visible below the ground
 * elements.
 */
public class Roots extends SpriteEntity {

    public Roots(Coordinate2D location) {
        super("entities/forrest/other/roots.png", location, new Size(60));
    }
}
