package com.github.hanyaeger.showcase.scenes.mapsandlegends.entities.slider;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.TileMap;

public class OpacitySlider extends Slider {

    public OpacitySlider(final Coordinate2D initialLocation, final TileMap map) {
        super(initialLocation, map, "Opacity");
    }

    @Override
    void applyValue(final YaegerEntity yaegerEntity, final double value) {
        yaegerEntity.setOpacity(value);
    }
}
