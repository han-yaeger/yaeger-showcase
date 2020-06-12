package nl.han.showcase.scenes.entitymaps;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.entitymaps.tilemaps.BoundedTileMap;
import nl.han.showcase.scenes.entitymaps.tilemaps.FullScreenTileMap;

public class TileMapScene extends DynamicScene implements TileMapContainer {

    private YaegerShowCase showCase;

    public TileMapScene(YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/milky-way.jpg");
    }

    @Override
    public void setupTileMaps() {
        var fullScreenMap = new FullScreenTileMap();
        addTileMap(fullScreenMap);

        var topLeftMap = new BoundedTileMap(new Location(0, 0), new Size(100, 100));
        topLeftMap.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addTileMap(topLeftMap);

        var topCentertMap = new BoundedTileMap(new Location(getWidth() / 2, 0), new Size(100, 100));
        topCentertMap.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addTileMap(topCentertMap);

        var topRighttMap = new BoundedTileMap(new Location(getWidth(), 0), new Size(100, 100));
        topRighttMap.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addTileMap(topRighttMap);

        var centerLeftMap = new BoundedTileMap(new Location(0, getHeight() / 2), new Size(100, 100));
        centerLeftMap.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addTileMap(centerLeftMap);

        var centeredMap = new BoundedTileMap(new Location(getWidth() / 2, getHeight() / 2), new Size(100, 100));
        centeredMap.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addTileMap(centeredMap);

        var centerRightMap = new BoundedTileMap(new Location(getWidth(), getHeight() / 2), new Size(100, 100));
        centerRightMap.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addTileMap(centerRightMap);

        var bottomLeftMap = new BoundedTileMap(new Location(0, getHeight()), new Size(100, 100));
        bottomLeftMap.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addTileMap(bottomLeftMap);

        var bottomCenterMap = new BoundedTileMap(new Location(getWidth() / 2, getHeight()), new Size(100, 100));
        bottomCenterMap.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addTileMap(bottomCenterMap);

        var bottomRightMap = new BoundedTileMap(new Location(getWidth(), getHeight()), new Size(100, 100));
        bottomRightMap.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addTileMap(bottomRightMap);
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(showCase, new Location(20, getHeight() - 30));
        addEntity(backButton);
    }
}
