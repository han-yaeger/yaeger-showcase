package nl.han.showcase.shared.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;

public class QuitButton extends SelectionButton {

    private static final String QUIT = "Quit";

    public QuitButton(final double y, final YaegerShowCase showCase) {
        super(y, QUIT, showCase, -1);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        showCase.quit();
    }
}
