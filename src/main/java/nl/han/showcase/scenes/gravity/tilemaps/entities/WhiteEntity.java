package nl.han.showcase.scenes.gravity.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.sprite.SpriteEntity;

public class WhiteEntity extends SpriteEntity implements Collider {

    public WhiteEntity(final Coordinate2D location, final Size size) {
        super("entities/block-white.png", location, size);
    }
}
