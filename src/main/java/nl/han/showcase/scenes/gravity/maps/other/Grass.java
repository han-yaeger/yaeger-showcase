package nl.han.showcase.scenes.gravity.maps.other;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Grass extends SpriteEntity {

    public Grass(Coordinate2D location, Size size) {
        super("entities/forrest/other/grass.png", location, size);
    }
}
