package nl.han.showcase.scenes.mapsandlegends.tilemaps;

import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import javafx.scene.paint.Color;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.CustomColorEntity;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.GrassEntity;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.entities.WhiteEntity;

public class FullScreenTileMap extends TileMap {

    @Override
    public void setupEntities() {
        addEntity(1, WhiteEntity.class);
        addEntity(2, CustomColorEntity.class, Color.RED);
        addEntity(3, CustomColorEntity.class, Color.ORANGE);
        addEntity(4, CustomColorEntity.class, Color.YELLOW);
        addEntity(5, CustomColorEntity.class, Color.GREEN);
        addEntity(6, CustomColorEntity.class, Color.BLUE);
        addEntity(7, GrassEntity.class, GrassEntity.GrassType.SIMPLE);
        addEntity(8, GrassEntity.class, GrassEntity.GrassType.COMPLEX);
        addEntity(9, GrassEntity.class, GrassEntity.GrassType.SHORT);
        addEntity(10, GrassEntity.class, GrassEntity.GrassType.LONG);
        addEntity(11, GrassEntity.class, GrassEntity.GrassType.DEAD);
    }

    @Override
    public int[][] defineMap() {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 7, 8, 9, 10, 11, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 7, 8, 9, 10, 11, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 7, 8, 9, 10, 11, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
        };
        return map;
    }
}
