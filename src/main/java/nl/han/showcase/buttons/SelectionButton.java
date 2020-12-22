package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.selection.SelectionScene;

public class SelectionButton extends Button {

    protected YaegerShowCase showCase;

    public SelectionButton(final double y, final String text, final YaegerShowCase showCase, final int scene) {
        super(new Coordinate2D(SelectionScene.LEFT_MARGIN, y), text, scene);
        this.showCase = showCase;

        setFill(Color.BLACK);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final double x, final double y) {
        showCase.setActiveScene(getScene());
    }
}
