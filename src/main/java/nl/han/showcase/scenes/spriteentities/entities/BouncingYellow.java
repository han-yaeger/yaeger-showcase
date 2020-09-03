package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;

public class BouncingYellow extends DynamicSpriteEntity {

    public BouncingYellow(final Coordinate2D initialLocation) {
        super("entities/bouncing-yellow.png", initialLocation, new Size(1757, 126), 14);
        setAutoCycle(20);
    }
}
