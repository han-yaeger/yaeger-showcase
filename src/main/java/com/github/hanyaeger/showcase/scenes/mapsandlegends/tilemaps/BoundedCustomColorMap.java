package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities.CustomColorEntityForTileMap;
import javafx.scene.paint.Color;

/**
 * In this {@link BoundedCustomColorMap} we use the same Entity, but change its color, by passing
 * this {@link Color} as the third parameter to the {@link TileMap#addEntity(int, Class, Object)}
 * method. This parameter is the passed to the constructor of the Entity, which uses it to set its
 * fill.
 */
public class BoundedCustomColorMap extends TileMap {

    public BoundedCustomColorMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, CustomColorEntityForTileMap.class, Color.PURPLE);
        addEntity(2, CustomColorEntityForTileMap.class, Color.DARKGREEN);
        addEntity(3, CustomColorEntityForTileMap.class, Color.GREENYELLOW);
        addEntity(4, CustomColorEntityForTileMap.class, Color.AZURE);
        addEntity(5, CustomColorEntityForTileMap.class, Color.INDIANRED);
        addEntity(6, CustomColorEntityForTileMap.class, Color.ORANGERED);
        addEntity(7, CustomColorEntityForTileMap.class, Color.DARKCYAN);
        addEntity(8, CustomColorEntityForTileMap.class, Color.MAGENTA);

    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {1, 2, 3},
                {4, 0, 5},
                {6, 7, 8}
        };
    }
}
