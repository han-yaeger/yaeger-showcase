package nl.han.showcase.shared.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.text.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private int scene;

    public Button(final Coordinate2D initialPosition, final String text, final int scene) {
        super(initialPosition, text);

        this.scene = scene;

        setFont(Font.font("Roboto", FontWeight.NORMAL, 25));
    }

    @Override
    public void onMouseEntered() {
        setFill(YaegerShowCase.HAN_RED);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.BLACK);
        setCursor(Cursor.DEFAULT);
    }

    public int getScene() {
        return scene;
    }
}
