package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities.CompositeEntityForTileMap;

public class BoundedCompositeMap extends TileMap {

    public BoundedCompositeMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, CompositeEntityForTileMap.class);
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
    }
}
