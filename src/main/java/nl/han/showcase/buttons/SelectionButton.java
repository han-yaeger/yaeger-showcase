package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.selection.SelectionScene;

public class SelectionButton extends Button {

    public SelectionButton(final double y, String text, YaegerShowCase showCase, int scene) {
        super(new Coordinate2D(SelectionScene.SELECTION_BUTTON_X, y), text, showCase, scene);
        setFill(Color.BLACK);
        setFont(HanFont.createDefaultCondensedFont(HanFontStyle.MEDIUM, 25));
    }
}
