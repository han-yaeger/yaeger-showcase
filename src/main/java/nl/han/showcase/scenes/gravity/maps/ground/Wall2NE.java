package nl.han.showcase.scenes.gravity.maps.ground;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Wall2NE extends SpriteEntity {

    public Wall2NE(Coordinate2D location, Size size) {
        super("entities/forrest/walls/wall2ne.png", location, size);
    }
}
