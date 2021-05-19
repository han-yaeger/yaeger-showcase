package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.ellipse.EllipseEntity;
import javafx.scene.paint.Color;

public class EllipseEntityForTileMap extends EllipseEntity {

    public EllipseEntityForTileMap(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);

        setStrokeWidth(1);
        setStrokeColor(Color.BLACK);
        setFill(Color.BLUEVIOLET);
    }
}
