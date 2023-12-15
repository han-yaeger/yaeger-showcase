package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities.EffectableEntityForEntityMap;
import javafx.scene.paint.Color;

/**
 * In this {@link BoundedChangeableMap} we use the same Entity, but change its color, by passing
 * this {@link Color} as the third parameter to the {@link TileMap#addEntity(int, Class, Object)}
 * method. This parameter is the passed to the constructor of the Entity, which uses it to set its
 * fill.
 */
public class BoundedChangeableMap extends TileMap {

    public BoundedChangeableMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, EffectableEntityForEntityMap.class);
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
