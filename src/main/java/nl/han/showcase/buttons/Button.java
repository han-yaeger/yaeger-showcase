package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseEnterListener;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseExitListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private int scene;

    public Button(final Coordinate2D initialPosition, final String text, final int scene) {
        super(initialPosition, text);

        this.scene = scene;

        setFont(HanFont.createDefaultCondensedFont(HanFontStyle.MEDIUM, 25));
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
