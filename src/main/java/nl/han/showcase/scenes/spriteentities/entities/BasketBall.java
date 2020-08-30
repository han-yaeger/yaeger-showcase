package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;

public class BasketBall extends DynamicSpriteEntity {

    public BasketBall(final Coordinate2D location) {
        super("entities/basketball.png", location, new Size(60, 60), 0);
        setRotationSpeed(1);
    }
}
