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


public class ButtonText extends TextEntity {

    public ButtonText(final Coordinate2D initialPosition, final String text) {
        super(initialPosition, text);
        setFill(Color.WHITE);
        setFont(HanFont.createDefaultCondensedFont(HanFontStyle.MEDIUM, 25));
    }

    public void onMouseEntered() {
        setFill(YaegerShowCase.HAN_RED);
    }

    public void onMouseExited() {
        setFill(Color.WHITE);
    }
}
