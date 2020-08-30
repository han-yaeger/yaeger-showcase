package nl.han.showcase.scenes.selection;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.api.engine.styles.HanFont;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.Button;
import nl.han.showcase.buttons.QuitButton;

import java.util.Set;

public class SelectionScene extends StaticScene implements KeyListener {

    public static final Color TEXT_COLOR = Color.YELLOW;
    public static final Color TEXT_COLOR_HIGHLIGHT = Color.LIGHTYELLOW;
    private static final Font TEXT_FONT = Font.font("American Typewriter", FontWeight.BOLD, 30);
    private YaegerShowCase showCase;

    public SelectionScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/nature.jpg");
    }

    @Override
    public void setupEntities() {
        var quitButton = new QuitButton(showCase, new Coordinate2D(20, getHeight() - 30));
        addEntity(quitButton);

        var select = new TextEntity(new Coordinate2D(20, 30), "Please select a scene...");
        styleText(select);
        addEntity(select);

        var textEntities = new Button(new Coordinate2D(20, 70), "1) Text Entities", showCase, YaegerShowCase.SCENE_TEXT_ENTITIES);
        styleText(textEntities);
        addEntity(textEntities);

        var spriteEntities = new Button(new Coordinate2D(20, 100), "2) Sprite Entities", showCase, YaegerShowCase.SCENE_SPRITE_ENTITIES);
        styleText(spriteEntities);
        addEntity(spriteEntities);

        var shapeEntities = new Button(new Coordinate2D(20, 130), "3) Shape Entities", showCase, YaegerShowCase.SCENE_SHAPE_ENTITIES);
        styleText(shapeEntities);
        addEntity(shapeEntities);

        var dynamicSceneWithTimers = new Button(new Coordinate2D(20, 160), "4) Dynamic Scene with a Timer", showCase, YaegerShowCase.SCENE_WITH_TIMERS);
        styleText(dynamicSceneWithTimers);
        addEntity(dynamicSceneWithTimers);

        var entityMapsScee = new Button(new Coordinate2D(20, 190), "5) Dynamic Scene with an EntityMap", showCase, YaegerShowCase.SCENE_WITH_ENTITYMAPS);
        styleText(entityMapsScee);
        addEntity(entityMapsScee);

        var entitySpawnerScene = new Button(new Coordinate2D(20, 220), "6) Ride the Lightning", showCase, YaegerShowCase.SCENE_WITH_SPAWNERS);
        styleText(entitySpawnerScene);
        addEntity(entitySpawnerScene);

        var distanceScene = new Button(new Coordinate2D(20, 250), "7) The distance", showCase, YaegerShowCase.SCENE_DISTANCE);
        styleText(distanceScene);
        addEntity(distanceScene);
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT1)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_TEXT_ENTITIES);
        } else if (pressedKeys.contains(KeyCode.DIGIT2)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_SPRITE_ENTITIES);
        } else if (pressedKeys.contains(KeyCode.DIGIT3)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_SHAPE_ENTITIES);
        } else if (pressedKeys.contains(KeyCode.DIGIT4)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_WITH_TIMERS);
        } else if (pressedKeys.contains(KeyCode.DIGIT5)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_WITH_ENTITYMAPS);
        } else if (pressedKeys.contains(KeyCode.DIGIT6)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_WITH_SPAWNERS);
        } else if (pressedKeys.contains(KeyCode.DIGIT7)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_DISTANCE);
        }
    }

    void styleText(TextEntity entity) {
        entity.setFill(TEXT_COLOR);
        entity.setFont(HanFont.createDefaultCondensedFont(25));
    }
}
