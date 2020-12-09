package nl.han.showcase.scenes.gravity.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class WhiteEntity extends SpriteEntity implements Collider {

    public WhiteEntity(Coordinate2D location, Size size) {
        super("entities/block-white.png", location, size);
    }
}
