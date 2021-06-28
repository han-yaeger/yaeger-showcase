package nl.han.showcase.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.selection.SelectionScene;

/**
 * Just a simple {@link com.github.hanyaeger.api.entities.impl.text.TextEntity}
 * that is used as a button.
 */
public class BackButton extends BorderButton {

    public static final String TEXT = "Back";
    private final YaegerShowCase showCase;

    public BackButton(final double y, final YaegerShowCase showCase) {
        super(new Coordinate2D(SelectionScene.LEFT_MARGIN, y), TEXT, 63);
        this.showCase = showCase;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        showCase.setActiveScene(YaegerShowCase.SCENE_SELECTION);
    }
}
