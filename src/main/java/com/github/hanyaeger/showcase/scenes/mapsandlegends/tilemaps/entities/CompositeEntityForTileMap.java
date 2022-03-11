package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class CompositeEntityForTileMap extends CompositeEntity {

    private Size size;

    public CompositeEntityForTileMap(final Coordinate2D initialLocation, final Size size) {
        super(initialLocation);
        this.size = size;
    }

    @Override
    protected void setupEntities() {
        var rectangle = new RectangleEntityForTileMap(new Coordinate2D(0, 0), size);
        addEntity(rectangle);

        var ellipse = new EllipseEntityForTileMap(new Coordinate2D(4, 4), new Size(size.width() - 8));
        addEntity(ellipse);
    }
}
