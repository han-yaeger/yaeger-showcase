package nl.han.showcase.scenes.entitymaps.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class WallnutTileMapEntity extends SpriteEntity {

    public WallnutTileMapEntity(Coordinate2D location, Size size) {
        super("entities/american-walnut.jpeg", location, size);
    }
}
