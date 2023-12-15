package com.github.hanyaeger.showcase.scenes.mapsandlegends.entities.slider;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.TileMap;

public class BrightnessSlider extends Slider {

    public BrightnessSlider(final Coordinate2D initialLocation, final TileMap map) {
        super(initialLocation, map, "Brightness");
    }

    @Override
    void applyValue(final YaegerEntity yaegerEntity, final double value) {
        yaegerEntity.setBrightness(value);
    }
}
