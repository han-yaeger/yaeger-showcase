package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;

public class QuitButton extends SelectionButton {

    private static final String QUIT = "Quit";

    public QuitButton(final double y, final YaegerShowCase showCase) {
        super(y, QUIT, showCase, -1);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final double x, final double y) {
        showCase.quit();
    }
}
