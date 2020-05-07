package nl.han.showcase.scenes.entitymaps.tilemaps;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import nl.han.showcase.scenes.entitymaps.tilemaps.entities.WallnutTileMapEntity;


public class BoundedTileMap extends TileMap {

    public BoundedTileMap(final Location location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(1, WallnutTileMapEntity.class);
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
