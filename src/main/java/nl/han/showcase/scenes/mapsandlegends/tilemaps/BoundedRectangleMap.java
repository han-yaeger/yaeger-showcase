package nl.han.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.RectangleEntityForTileMap;

public class BoundedRectangleMap extends TileMap {

    public BoundedRectangleMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, RectangleEntityForTileMap.class);
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
