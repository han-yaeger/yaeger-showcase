package nl.han.showcase.scenes.entitymaps;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.entitymaps.tilemaps.BoundedTileMap;
import nl.han.showcase.scenes.entitymaps.tilemaps.FullScreenTileMap;

public class TileMapScene extends ShowCaseScene implements TileMapContainer {

    public TileMapScene(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/purple.jpg");
    }

    @Override
    public void setupTileMaps() {
        var fullScreenMap = new FullScreenTileMap();
        addTileMap(fullScreenMap);

        var topLeftMap = new BoundedTileMap(new Coordinate2D(0, 0), new Size(100, 100));
        topLeftMap.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addTileMap(topLeftMap);

        var topCentertMap = new BoundedTileMap(new Coordinate2D(getWidth() / 2, 0), new Size(100, 100));
        topCentertMap.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addTileMap(topCentertMap);

        var topRighttMap = new BoundedTileMap(new Coordinate2D(getWidth(), 0), new Size(100, 100));
        topRighttMap.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addTileMap(topRighttMap);

        var centerLeftMap = new BoundedTileMap(new Coordinate2D(0, getHeight() / 2), new Size(100, 100));
        centerLeftMap.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addTileMap(centerLeftMap);

        var centeredMap = new BoundedTileMap(new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(100, 100));
        centeredMap.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addTileMap(centeredMap);

        var centerRightMap = new BoundedTileMap(new Coordinate2D(getWidth(), getHeight() / 2), new Size(100, 100));
        centerRightMap.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addTileMap(centerRightMap);

        var bottomLeftMap = new BoundedTileMap(new Coordinate2D(0, getHeight()), new Size(100, 100));
        bottomLeftMap.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addTileMap(bottomLeftMap);

        var bottomCenterMap = new BoundedTileMap(new Coordinate2D(getWidth() / 2, getHeight()), new Size(100, 100));
        bottomCenterMap.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addTileMap(bottomCenterMap);

        var bottomRightMap = new BoundedTileMap(new Coordinate2D(getWidth(), getHeight()), new Size(100, 100));
        bottomRightMap.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addTileMap(bottomRightMap);
    }
}
