package nl.han.showcase.shared.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.selection.SelectionScene;

public class BackButton extends BorderButton {

    public static final String TEXT = "Back";
    private final YaegerShowCase showCase;

    public BackButton(final double y, final YaegerShowCase showCase) {
        this(new Coordinate2D(SelectionScene.LEFT_MARGIN, y), showCase);
    }

    public BackButton(final Coordinate2D coordinate2D, final YaegerShowCase showCase) {
        super(coordinate2D, TEXT, 63);
        this.showCase = showCase;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        showCase.setActiveScene(YaegerShowCase.SCENE_SELECTION);
    }
}
