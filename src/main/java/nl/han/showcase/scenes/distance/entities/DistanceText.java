package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.text.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A simple {@link DynamicTextEntity} that implements the interface {@link UpdateExposer}
 * to update its text continuously.
 */
public class DistanceText extends DynamicTextEntity implements UpdateExposer {

    private final YaegerEntity target;
    private final YaegerEntity origin;

    public DistanceText(final Coordinate2D initialPosition, final YaegerEntity origin, final YaegerEntity target) {
        super(initialPosition);
        this.origin = origin;
        this.target = target;
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 14));
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        setText("Distance: " + Math.round(origin.distanceTo(target)));
    }
}
