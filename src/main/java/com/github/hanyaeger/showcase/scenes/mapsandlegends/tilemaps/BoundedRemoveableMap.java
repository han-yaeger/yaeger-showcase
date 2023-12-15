package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import javafx.scene.paint.Color;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities.RemoveableEntityForTileMap;

/**
 * In this {@link BoundedRemoveableMap} we use the same Entity, but change its color, by passing
 * this {@link Color} as the third parameter to the {@link TileMap#addEntity(int, Class, Object)}
 * method. This parameter is the passed to the constructor of the Entity, which uses it to set its
 * fill.
 */
public class BoundedRemoveableMap extends TileMap {

    public BoundedRemoveableMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, RemoveableEntityForTileMap.class);
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
    }
}
