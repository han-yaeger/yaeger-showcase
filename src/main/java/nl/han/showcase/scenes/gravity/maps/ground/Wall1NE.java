package nl.han.showcase.scenes.gravity.maps.ground;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Wall1NE extends SpriteEntity implements Collider {

    public Wall1NE(Coordinate2D location, Size size) {
        super("entities/forrest/walls/wall1ne.png", location, size);
    }
}
