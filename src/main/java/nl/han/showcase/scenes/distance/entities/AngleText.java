package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.text.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.scenes.distance.entities.textfield.DynamicShowCaseTextField;

/**
 * A simple {@link DynamicTextEntity} that implements the interface {@link UpdateExposer}
 * to update its text continuously.
 */
public class AngleText extends DynamicShowCaseTextField implements UpdateExposer {

    private final YaegerEntity target;
    private final YaegerEntity origin;

    public AngleText(final Coordinate2D initialPosition, final YaegerEntity origin, final YaegerEntity target) {
        super(initialPosition, "Angle");
        this.origin = origin;
        this.target = target;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        setValue(String.valueOf(Math.round(origin.angleTo(target))));
    }
}
