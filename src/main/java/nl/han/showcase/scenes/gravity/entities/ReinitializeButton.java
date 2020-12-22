package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.Button;
import nl.han.showcase.buttons.SelectionButton;
import nl.han.showcase.scenes.gravity.Gravity;

/**
 * Just a simple {@link com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity}
 * that is used as a button.
 */
public class ReinitializeButton extends Button {

    public static final String TEXT = "Reinitialize";
    private final Gravity gravity;

    public ReinitializeButton(final Coordinate2D location, final Gravity gravity) {
        super(location, TEXT, YaegerShowCase.SCENE_SELECTION);
        this.gravity = gravity;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        gravity.resetEntities();
    }
}
