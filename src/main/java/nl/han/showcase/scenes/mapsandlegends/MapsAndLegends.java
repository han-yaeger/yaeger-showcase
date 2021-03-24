package nl.han.showcase.scenes.mapsandlegends;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.*;

/**
 * There are two flavours of TileMaps. Those that cover the entire {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}
 * and thos that only take up a give area. In this Scene we demonstrate several implementations, and how we can
 * use the {@link com.github.hanyaeger.api.engine.entities.tilemap.TileMap#setAnchorPoint(AnchorPoint)} to put them on the
 * Scene.
 */
public class MapsAndLegends extends ShowCaseScene implements TileMapContainer {

    // A constant that is used as the top, right, bottom and left margin.
    private static final double MARGIN = 100d;

    public MapsAndLegends(final YaegerShowCase showCase) {
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

        var topLeftMap = new BoundedRectangleMap(new Coordinate2D(MARGIN, MARGIN), new Size(100, 100));
        topLeftMap.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addTileMap(topLeftMap);

        var topCentertMap = new BoundedDynamicRectangleMap(new Coordinate2D(getWidth() / 2, MARGIN), new Size(100, 100));
        topCentertMap.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addTileMap(topCentertMap);

        var topRighttMap = new BoundedEllipseMap(new Coordinate2D(getWidth() - MARGIN, MARGIN), new Size(100, 100));
        topRighttMap.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addTileMap(topRighttMap);

        var centerLeftMap = new BoundedCompositeMap(new Coordinate2D(MARGIN, getHeight() / 2), new Size(100, 100));
        centerLeftMap.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addTileMap(centerLeftMap);

        var centeredMap = new BoundedCustomColorMap(new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(100, 100));
        centeredMap.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addTileMap(centeredMap);

        var centerRightMap = new BoundedCustomColorMap(new Coordinate2D(getWidth() - MARGIN, getHeight() / 2), new Size(100, 100));
        centerRightMap.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addTileMap(centerRightMap);

        var bottomLeftMap = new BoundedCustomColorMap(new Coordinate2D(MARGIN, getHeight() - MARGIN), new Size(100, 100));
        bottomLeftMap.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addTileMap(bottomLeftMap);

        var bottomCenterMap = new BoundedCustomColorMap(new Coordinate2D(getWidth() / 2, getHeight() - MARGIN), new Size(100, 100));
        bottomCenterMap.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addTileMap(bottomCenterMap);

        var bottomRightMap = new BoundedTileMap(new Coordinate2D(getWidth() - MARGIN, getHeight() - MARGIN), new Size(100, 100));
        bottomRightMap.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addTileMap(bottomRightMap);
    }
}
