package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.buttons.BorderButton;
import nl.han.showcase.scenes.gravity.Gravity;

public class ResetButton extends BorderButton {

    public static final String TEXT = "Reset";
    private final Gravity gravity;

    public ResetButton(final Coordinate2D location, final Gravity gravity) {
        super(location, TEXT, 70);
        this.gravity = gravity;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        gravity.resetEntities();
    }
}
