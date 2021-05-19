package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.sprite.SpriteEntity;

public class WhiteEntityForTileMap extends SpriteEntity {

    public WhiteEntityForTileMap(final Coordinate2D location, final Size size) {
        super("entities/block-white.png", location, size);
    }
}
