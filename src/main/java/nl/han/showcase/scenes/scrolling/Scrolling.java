package nl.han.showcase.scenes.scrolling;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.scrolling.entities.Bat;
import nl.han.showcase.scenes.scrolling.entities.Torch;
import nl.han.showcase.scenes.scrolling.entities.Zombie;
import nl.han.showcase.shared.buttons.BackButton;
import nl.han.showcase.shared.textfield.DynamicShowCaseTextField;

import java.util.Set;

public class Scrolling extends ScrollableDynamicScene implements KeyListener {

    protected YaegerShowCase showCase;

    public Scrolling(final YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/dungeon.png");
        setSize(new Size(2223, 698));
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(getHeight() - ShowCaseScene.BOTTOM_MARGIN, showCase);
        addEntity(backButton, true);

        addTorches();
        addFoes();
    }

    private void addFoes() {
        var bat = new Bat(new Coordinate2D(100, 100));
        addEntity(bat);

        var zombie = new Zombie(new Coordinate2D(300, 582));
        addEntity(zombie);
    }

    private void addTorches() {
        var torch0 = new Torch(new Coordinate2D(-15, 500));
        addEntity(torch0);

        var torch1 = new Torch(new Coordinate2D(430, 500));
        addEntity(torch1);

        var torch2 = new Torch(new Coordinate2D(875, 500));
        addEntity(torch2);

        var torch3 = new Torch(new Coordinate2D(1320, 500));
        addEntity(torch3);

        var torch4 = new Torch(new Coordinate2D(1765, 500));
        addEntity(torch4);

        var torch5 = new Torch(new Coordinate2D(2210, 500));
        addEntity(torch5);
    }

    @Override
    public void onPressedKeysChange(final Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT1)) {
            var scene = getScene();
            System.out.println(scene);
        }
    }
}
