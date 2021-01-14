package nl.han.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.DynamicRectangleEntityForEntityMap;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.RectangleEntityForEntityMap;

public class BoundedDynamicRectangleMap extends TileMap {

    public BoundedDynamicRectangleMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, DynamicRectangleEntityForEntityMap.class);
    }

    @Override
    public int[][] defineMap() {
        int[][] map = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        return map;
    }
}
