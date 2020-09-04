package nl.han.showcase.scenes.selection;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.QuitButton;
import nl.han.showcase.buttons.SelectionButton;

import java.util.Set;

/**
 * A {@link StaticScene} that only contains the menu for selecting the
 * {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}. Besides buttons,
 * which are just instances of {@link TextEntity}, this {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}
 * also listens to the keyboard, by implementing the {@link KeyListener} interface.
 */
public class SelectionScene extends StaticScene implements KeyListener {

    public static final double SELECTION_BUTTON_X = 34;
    private static final String TEXT_PLEASE_SELECT = "PLEASE SELECT A SCENE:";
    private YaegerShowCase showCase;

    public SelectionScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/selection.jpg");
    }

    @Override
    public void setupEntities() {
        var quitButton = new QuitButton(getHeight() - 30, showCase);
        addEntity(quitButton);

        var select = new TextEntity(new Coordinate2D(SELECTION_BUTTON_X, 95), TEXT_PLEASE_SELECT);
        select.setFill(Color.BLACK);
        select.setFont(HanFont.createDefaultCondensedFont(HanFontStyle.BOLD, 23));
        addEntity(select);

        var textEntities = new SelectionButton(150, YaegerShowCase.SCENE_ROADS_GO_EVER_ON_TITLE, showCase, YaegerShowCase.SCENE_ROADS_GO_EVER_ON);
        addEntity(textEntities);

        var spriteEntities = new SelectionButton(200, YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE_TITLE, showCase, YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE);
        addEntity(spriteEntities);

        var shapeEntities = new SelectionButton(250, YaegerShowCase.SCENE_SHAPE_TITLE, showCase, YaegerShowCase.SCENE_SHAPE);
        addEntity(shapeEntities);

        var dynamicSceneWithTimers = new SelectionButton(300, YaegerShowCase.SCENE_TIME_TITLE, showCase, YaegerShowCase.SCENE_TIME);
        addEntity(dynamicSceneWithTimers);

        var entityMapsScee = new SelectionButton(350, YaegerShowCase.SCENE_MAPS_TITLE, showCase, YaegerShowCase.SCENE_MAPS);
        addEntity(entityMapsScee);

        var entitySpawnerScene = new SelectionButton(400, YaegerShowCase.SCENE_RIDE_THE_LIGHTNING_TITLE, showCase, YaegerShowCase.SCENE_RIDE_THE_LIGHTNING);
        addEntity(entitySpawnerScene);

        var distanceScene = new SelectionButton(450, YaegerShowCase.SCENE_DISTANCE_TITLE, showCase, YaegerShowCase.SCENE_DISTANCE);
        addEntity(distanceScene);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT1)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_ROADS_GO_EVER_ON);
        } else if (pressedKeys.contains(KeyCode.DIGIT2)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE);
        } else if (pressedKeys.contains(KeyCode.DIGIT3)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_SHAPE);
        } else if (pressedKeys.contains(KeyCode.DIGIT4)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_TIME);
        } else if (pressedKeys.contains(KeyCode.DIGIT5)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_MAPS);
        } else if (pressedKeys.contains(KeyCode.DIGIT6)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_RIDE_THE_LIGHTNING);
        } else if (pressedKeys.contains(KeyCode.DIGIT7)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_DISTANCE);
        }
    }
}
