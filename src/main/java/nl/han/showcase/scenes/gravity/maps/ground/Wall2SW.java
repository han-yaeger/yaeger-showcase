package nl.han.showcase.scenes.gravity.maps.ground;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Wall2SW extends SpriteEntity {

    public Wall2SW(Coordinate2D location, Size size) {
        super("entities/forrest/walls/wall1sw.png", location, size);
    }
}
