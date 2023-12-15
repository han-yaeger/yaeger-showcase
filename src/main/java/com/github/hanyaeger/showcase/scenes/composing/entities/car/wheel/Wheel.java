package com.github.hanyaeger.showcase.scenes.composing.entities.car.wheel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Wheel extends DynamicCompositeEntity {

    public Wheel(final Coordinate2D initialLocation) {
        super(initialLocation);
        setRotationSpeed(-4);
    }

    @Override
    protected void setupEntities() {
        var spoke1 = new Spoke(new Coordinate2D(30, 30));
        addEntity(spoke1);
        var spoke2 = new Spoke(new Coordinate2D(30, 30));
        spoke2.setRotate(45);
        addEntity(spoke2);
        var spoke3 = new Spoke(new Coordinate2D(30, 30));
        spoke3.setRotate(90);
        addEntity(spoke3);
        var spoke4 = new Spoke(new Coordinate2D(30, 30));
        spoke4.setRotate(135);
        addEntity(spoke4);
        var tire = new Tire(new Coordinate2D(30, 30));
        addEntity(tire);
    }
}
