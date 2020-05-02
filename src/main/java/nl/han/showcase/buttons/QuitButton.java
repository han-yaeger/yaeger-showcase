package nl.han.showcase.buttons;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.yaeger.engine.entities.entity.AnchorPoint;
import nl.han.yaeger.engine.entities.entity.Location;

public class QuitButton extends Button {

    private static final String QUIT = "Quit";

    public QuitButton(final YaegerShowCase showCase, final Location location) {
        super(location, QUIT, showCase, -1);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(Color.SNOW);
        setFont(Font.font("palatino", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final double x, final double y) {
        showCase.quitGame();
    }
}
