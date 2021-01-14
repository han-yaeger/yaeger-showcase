package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.CompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;

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

        var ellipse = new EllipseEntityForTileMap(new Coordinate2D(4, 4), new Size(size.getWidth() - 8));
        addEntity(ellipse);
    }
}
