package nl.han.showcase.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.text.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;


public class ButtonText extends TextEntity {

    public ButtonText(final Coordinate2D initialPosition, final String text) {
        super(initialPosition, text);
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 25));
    }

    public void onMouseEntered() {
        setFill(YaegerShowCase.HAN_RED);
    }

    public void onMouseExited() {
        setFill(Color.WHITE);
    }
}
