package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class PurpleEntityForTileMap extends SpriteEntity {

    public PurpleEntityForTileMap(final Coordinate2D location, final Size size) {
        super("entities/block-purple.png", location, size);
    }
}
