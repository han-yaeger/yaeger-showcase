package nl.han.showcase.scenes.gravity.entities.walls;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class Wall2SE extends SpriteEntity {

    public Wall2SE(Coordinate2D location, Size size) {
        super("entities/forrest/walls/wall2se.png", location, size);
    }
}
