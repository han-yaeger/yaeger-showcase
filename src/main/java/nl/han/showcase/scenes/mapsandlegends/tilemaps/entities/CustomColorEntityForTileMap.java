package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

public class CustomColorEntityForTileMap extends RectangleEntity {

    public CustomColorEntityForTileMap(final Coordinate2D initialPosition, final Size size, final Color color) {
        super(initialPosition, size);

        setStrokeWidth(1);
        setStrokeColor(Color.BLACK);
        setFill(color);
    }
}
