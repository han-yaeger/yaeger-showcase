package nl.han.showcase.scenes.scrollingstones;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.scrollingstones.entities.game.Earth;
import nl.han.showcase.scenes.scrollingstones.entities.game.Star;
import nl.han.showcase.scenes.scrollingstones.spawners.RockSpawner;
import nl.han.showcase.scenes.scrollingstones.tilemaps.SatelliteTileMap;
import nl.han.showcase.shared.HanLogoHeader;
import nl.han.showcase.shared.buttons.BackButton;
import nl.han.showcase.shared.explosion.Explosion;
import nl.han.showcase.shared.explosion.ExplosionAdder;
import nl.han.showcase.shared.textfield.ShowCaseTextField;

import java.util.Random;

/**
 * In this {@code ScrollingStones}, a {@link ScrollableDynamicScene} is used to create a classic
 * dungeon-based scrolling game. The actual level is much wider than de visible area of the
 * {@link com.github.hanyaeger.api.scenes.YaegerScene}.
 */
public class ScrollingStones extends ScrollableDynamicScene implements EntitySpawnerContainer, TileMapContainer, ExplosionAdder, MouseMovedListener, MouseButtonPressedListener, MouseButtonReleasedListener {

    private static final double TEXTFIELD_MARGIN = 150D;
    private static final double TEXTFIELD_DELTA = 50D;
    private static final double TEXTFIELD_SCENE_START = 50D;

    protected YaegerShowCase showCase;

    private ShowCaseTextField sceneMousePointerMovedTextField;
    private ShowCaseTextField sceneMousePointerPressedTextField;
    private ShowCaseTextField sceneMousePointerReleasedTextField;

    public ScrollingStones(final YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupScene() {
        // We set a black background color.
        setBackgroundColor(Color.BLACK);

        // The size is the same as the image.
        setSize(new Size(2000, 2000));

        // By setting the horizontal and vertical scroll position to .5, we ensure that the viewport is centered
        setVerticalScrollPosition(0.5);
        setHorizontalScrollPosition(0.5);
    }

    @Override
    public void setupEntities() {
        // Since the background is lacking the HAN logo, we add it with stickyOnViewPort `true`
        addEntity(new HanLogoHeader(), true);

        // Since the backbutton should be visible at all times, we add it with stickyOnViewPort `true`
        var backButton = new BackButton(getViewportHeight() - ShowCaseScene.BOTTOM_MARGIN, showCase);
        addEntity(backButton, true);

        // The text field that display information about mouse events are added to the viewport
        addMouseListenersTextFields();

        // Add Mouse controlling entities


        addStars();
        addEntity(new Earth(new Coordinate2D(getWidth() / 2, getHeight() / 2)));
    }

    private void addMouseListenersTextFields() {
        var sceneHeader = new TextEntity(new Coordinate2D(getViewportWidth() - TEXTFIELD_MARGIN, TEXTFIELD_SCENE_START - 20), "Scene Mouse events");
        sceneHeader.setFont(Font.font("Roboto", 10));
        sceneHeader.setFill(YaegerShowCase.HAN_RED);
        addEntity(sceneHeader, true);

        sceneMousePointerMovedTextField = new ShowCaseTextField(new Coordinate2D(getViewportWidth() - TEXTFIELD_MARGIN, TEXTFIELD_SCENE_START), "Mouse moved", Color.TRANSPARENT);
        addEntity(sceneMousePointerMovedTextField, true);

        sceneMousePointerPressedTextField = new ShowCaseTextField(new Coordinate2D(getViewportWidth() - TEXTFIELD_MARGIN, TEXTFIELD_SCENE_START + TEXTFIELD_DELTA), "Mouse pressed", Color.TRANSPARENT);
        addEntity(sceneMousePointerPressedTextField, true);

        sceneMousePointerReleasedTextField = new ShowCaseTextField(new Coordinate2D(getViewportWidth() - TEXTFIELD_MARGIN, TEXTFIELD_SCENE_START + 2 * TEXTFIELD_DELTA), "Mouse released", Color.TRANSPARENT);
        addEntity(sceneMousePointerReleasedTextField, true);
    }

    private void addStars() {
        // We add 2000 entities that represent stars
        for (int i = 0; i < 2000; i++) {
            int x = new Random().nextInt((int) getWidth());
            int y = new Random().nextInt((int) getHeight());
            addEntity(new Star(new Coordinate2D(x, y)));
        }
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new RockSpawner(800, getWidth(), getHeight(), this));
    }

    @Override
    public void addExplosion(final Coordinate2D anchorLocation, final double speed, final double direction) {
        addEntity(new Explosion(anchorLocation, speed, direction));
    }

    @Override
    public void onMouseMoved(final Coordinate2D coordinate2D) {
        sceneMousePointerMovedTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        sceneMousePointerPressedTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, Coordinate2D coordinate2D) {
        sceneMousePointerReleasedTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new SatelliteTileMap(this));
    }
}
