package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class GrassEntityForTileMap extends SpriteEntity {

    public GrassEntityForTileMap(final Coordinate2D location, final Size size, final GrassType grassType) {
        super(grassType.sprite, location, size);
    }

    public enum GrassType {
        SIMPLE("entities/grass_simple.png"),
        COMPLEX("entities/grass_complex.png"),
        SHORT("entities/grass_short.png"),
        LONG("entities/grass_long.png"),
        DEAD("entities/grass_dead.png");

        String sprite;

        GrassType(String sprite) {
            this.sprite = sprite;
        }
    }
}
