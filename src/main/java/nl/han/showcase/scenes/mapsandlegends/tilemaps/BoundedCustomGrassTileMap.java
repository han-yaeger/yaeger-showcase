package nl.han.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.GrassEntityForTileMap;


public class BoundedCustomGrassTileMap extends TileMap {

    public BoundedCustomGrassTileMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {

        addEntity(1, GrassEntityForTileMap.class, GrassEntityForTileMap.GrassType.SIMPLE);
        addEntity(2, GrassEntityForTileMap.class, GrassEntityForTileMap.GrassType.COMPLEX);
        addEntity(3, GrassEntityForTileMap.class, GrassEntityForTileMap.GrassType.SHORT);
        addEntity(4, GrassEntityForTileMap.class, GrassEntityForTileMap.GrassType.LONG);
        addEntity(5, GrassEntityForTileMap.class, GrassEntityForTileMap.GrassType.DEAD);
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {1, 2, 1},
                {3, 0, 3},
                {4, 5, 4}
        };
    }
}
