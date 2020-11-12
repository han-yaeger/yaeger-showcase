package nl.han.showcase.scenes.composing.entities.waterworld.swordfish;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class SwordfishSprite extends SpriteEntity {

    public SwordfishSprite(Coordinate2D location) {
        super("entities/swordfish.png", location, new Size(225, 81));
    }
}
