package com.github.hanyaeger.showcase.scenes.mapsandlegends;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.entities.slider.*;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.*;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.ShowCaseScene;

/**
 * There are two flavours of TileMaps. Those that cover the entire {@link com.github.hanyaeger.api.scenes.DynamicScene}
 * and those that only take up a give area. In this Scene we demonstrate several implementations, and how we can
 * use the {@link com.github.hanyaeger.api.scenes.TileMap#setAnchorPoint(com.github.hanyaeger.api.AnchorPoint)} to put them on the
 * Scene.
 */
public class MapsAndLegends extends ShowCaseScene implements TileMapContainer {

    // A constant that is used as the top, right, bottom and left margin.
    private static final double MARGIN = 100d;

    private BoundedChangeableMap bottomCenterMap;

    public MapsAndLegends(final YaegerShowCase showCase) {

        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/purple.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        // First we initialize the BoundedChangeableMap, to ensure the reference is not null
        // when we pass it to the sliders.
        bottomCenterMap = new BoundedChangeableMap(new Coordinate2D(getWidth() / 2, getHeight() - MARGIN), new Size(100, 100));
        bottomCenterMap.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);

        var opacitySlider = new OpacitySlider(new Coordinate2D(380, 620), bottomCenterMap);
        addEntity(opacitySlider);

        var brightnessSlider = new BrightnessSlider(new Coordinate2D(380, 650), bottomCenterMap);
        addEntity(brightnessSlider);

        var contrastSlider = new ContrastSlider(new Coordinate2D(480, 620), bottomCenterMap);
        addEntity(contrastSlider);

        var hueSlider = new HueSlider(new Coordinate2D(480, 650), bottomCenterMap);
        addEntity(hueSlider);

        var saturationSlider = new SaturationSlider(new Coordinate2D(580, 620), bottomCenterMap);
        addEntity(saturationSlider);
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

        var topRightMap = new BoundedEllipseMap(new Coordinate2D(getWidth() - MARGIN, MARGIN), new Size(100, 100));
        topRightMap.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addTileMap(topRightMap);

        var centerLeftMap = new BoundedCompositeMap(new Coordinate2D(MARGIN, getHeight() / 2), new Size(100, 100));
        centerLeftMap.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addTileMap(centerLeftMap);

        var centeredMap = new BoundedCustomColorMap(new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(100, 100));
        centeredMap.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addTileMap(centeredMap);

        var centerRightMap = new BoundedCustomGrassTileMap(new Coordinate2D(getWidth() - MARGIN, getHeight() / 2), new Size(100, 100));
        centerRightMap.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addTileMap(centerRightMap);

        var bottomLeftMap = new BoundedRemoveableMap(new Coordinate2D(MARGIN, getHeight() - MARGIN), new Size(100, 100));
        bottomLeftMap.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addTileMap(bottomLeftMap);

        // Here we added the previously created TileMap
        addTileMap(bottomCenterMap);

        var bottomRightMap = new BoundedTileMap(new Coordinate2D(getWidth() - MARGIN, getHeight() - MARGIN), new Size(100, 100));
        bottomRightMap.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addTileMap(bottomRightMap);
    }
}
