package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class DynamicRectangleEntityForTileMap extends DynamicRectangleEntity implements UpdateExposer {

    private static final double ARC_MIN = 0;
    private static final double ARC_MAX = 110;
    private double currentArc = 0;
    private boolean decreasing = false;

    public DynamicRectangleEntityForTileMap(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);

        setStrokeWidth(1);
        setStrokeColor(Color.BLACK);
        setFill(Color.PURPLE);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        if (!decreasing && currentArc < ARC_MAX - 1) {
            currentArc++;
        } else if (decreasing && currentArc > ARC_MIN + 1) {
            currentArc--;
        } else {
            decreasing = !decreasing;
        }

        setArcHeight(currentArc);
        setArcWidth(currentArc);
    }
}
