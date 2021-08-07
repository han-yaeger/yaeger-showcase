package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import nl.han.showcase.shared.textfield.DynamicShowCaseTextField;

/**
 * A simple {@link DynamicTextEntity} that implements the interface {@link UpdateExposer}
 * to update its text continuously.
 */
public class DistanceText extends DynamicShowCaseTextField implements UpdateExposer {

    private YaegerEntity origin;
    private final YaegerEntity target;

    public DistanceText(final Coordinate2D initialPosition, final YaegerEntity origin, final YaegerEntity target) {
        super(initialPosition, "Distance");
        this.origin = origin;
        this.target = target;
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        setValue(String.valueOf(Math.round(origin.distanceTo(target))));
    }
}
