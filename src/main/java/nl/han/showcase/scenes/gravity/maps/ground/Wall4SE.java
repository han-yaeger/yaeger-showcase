package nl.han.showcase.scenes.gravity.maps.ground;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Wall4SE extends SpriteEntity{

    public Wall4SE(Coordinate2D location, Size size) {
        super("entities/forrest/walls/wall4se.png", location, size);
    }
}
