package nl.han.showcase.scenes.scrollingstones;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.scrollingstones.entities.game.Bat;
import nl.han.showcase.scenes.scrollingstones.entities.game.FlameSpirit;
import nl.han.showcase.scenes.scrollingstones.entities.game.Torch;
import nl.han.showcase.scenes.scrollingstones.entities.game.Zombie;
import nl.han.showcase.scenes.scrollingstones.entities.sticky.ViewPortHTextField;
import nl.han.showcase.shared.buttons.BackButton;

import java.util.Set;

/**
 * In this {@code ScrollingStones}, a {@link ScrollableDynamicScene} is used to create a classic
 * dungeon-based scrolling game. The actual level is much wider than de visible area of the
 * {@link com.github.hanyaeger.api.scenes.YaegerScene}.
 */
public class ScrollingStones extends ScrollableDynamicScene implements KeyListener {

    protected YaegerShowCase showCase;
    private static final double X_START_TORCH = -15;
    private static final double Y_TORCH = 500;
    private static final double X_DELTA_TORCH = 444;
    private static final int NUMBER_OF_TORCHES = 11;

    public ScrollingStones(final YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupScene() {
        // We set {@code fullscreen} to {@code false} to ensure the image is tiled
        setBackgroundImage("backgrounds/dungeon.png", false);
        // The size is twice as wide as the image used.
        setSize(new Size(4446, 698));
    }

    @Override
    public void setupEntities() {
        // Since the backbutton should be visible at all times, we add it with stickyOnViewPort `true`
        var backButton = new BackButton(getHeight() - ShowCaseScene.BOTTOM_MARGIN, showCase);
        addEntity(backButton, true);

        var viewPortHValue = new ViewPortHTextField(new Coordinate2D(20, 10), this);
        addEntity(viewPortHValue, true);

        addTorches();
        addFoes();

        var player = new FlameSpirit(new Coordinate2D(50, 550));
        addEntity(player);
    }

    private void addFoes() {
        var bat = new Bat(new Coordinate2D(100, 100));
        addEntity(bat);

        var zombie = new Zombie(new Coordinate2D(300, 582));
        addEntity(zombie);
    }

    private void addTorches() {

        var x = X_START_TORCH;

        for (int i = 0; i < NUMBER_OF_TORCHES; i++) {
            var torch = new Torch(new Coordinate2D(x, Y_TORCH));
            addEntity(torch);
            x += X_DELTA_TORCH;
        }
    }

    @Override
    public void onPressedKeysChange(final Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT1)) {
            var scene = getScene();
            System.out.println(scene);
        }
    }
}
