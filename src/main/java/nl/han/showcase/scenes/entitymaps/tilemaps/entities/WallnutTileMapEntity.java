package nl.han.showcase.scenes.entitymaps.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class WallnutTileMapEntity extends SpriteEntity {

    public WallnutTileMapEntity(Location location, Size size) {
        super("entities/american-walnut.jpeg", location, size);
    }
}
