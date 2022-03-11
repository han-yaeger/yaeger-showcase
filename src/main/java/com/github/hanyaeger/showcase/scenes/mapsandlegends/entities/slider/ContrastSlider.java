package com.github.hanyaeger.showcase.scenes.mapsandlegends.entities.slider;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.TileMap;

public class ContrastSlider extends Slider {

    public ContrastSlider(final Coordinate2D initialLocation, final TileMap map) {
        super(initialLocation, map, "Contrast");
    }

    @Override
    void applyValue(final YaegerEntity yaegerEntity, final double value) {
        yaegerEntity.setContrast(value);
    }
}
