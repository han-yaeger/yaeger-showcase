package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseEnterListener;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseExitListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.selection.SelectionScene;


public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    protected YaegerShowCase showCase;
    private int scene;

    public Button(final Coordinate2D initialPosition, final String text, YaegerShowCase showCase, int scene) {
        super(initialPosition, text);
        this.showCase = showCase;
        this.scene = scene;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        showCase.setActiveScene(scene);
    }

    @Override
    public void onMouseEntered() {
        setFill(SelectionScene.TEXT_COLOR_HIGHLIGHT);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(SelectionScene.TEXT_COLOR);
        setCursor(Cursor.DEFAULT);
    }
}
