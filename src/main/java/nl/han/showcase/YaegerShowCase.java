package nl.han.showcase;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.YaegerGame;
import javafx.scene.paint.Color;
import nl.han.showcase.scenes.distance.TheDistanceScene;
import nl.han.showcase.scenes.dynamicscenewithtimer.DynamicSceneWithTimer;
import nl.han.showcase.scenes.entitymaps.TileMapScene;
import nl.han.showcase.scenes.selection.SelectionScene;
import nl.han.showcase.scenes.shapeentities.ShapeEntitiesScene;
import nl.han.showcase.scenes.ridethelightning.RideTheLightningScene;
import nl.han.showcase.scenes.spriteentities.SpriteEntitiesScene;
import nl.han.showcase.scenes.textentities.TextEntitiesScene;

/**
 * ShowCase of all Yaeger Features.
 */
public class YaegerShowCase extends YaegerGame {

    private static final String GAME_TITLE = "Yaeger Show Case";
    public static final Color HAN_RED = Color.rgb(229, 0, 85);
    private static final int WIDTH = 880;
    private static final int HEIGHT = 600;
    public static final int SCENE_SELECTION = 1;
    public static final int SCENE_TEXT_ENTITIES = 2;
    public static final int SCENE_SPRITE_ENTITIES = 3;
    public static final int SCENE_SHAPE_ENTITIES = 4;
    public static final int SCENE_WITH_TIMERS = 5;
    public static final int SCENE_WITH_ENTITYMAPS = 6;
    public static final int SCENE_WITH_SPAWNERS = 7;
    public static final int SCENE_DISTANCE = 8;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void setupGame() {
        setGameTitle(GAME_TITLE);
        setSize(new Size(WIDTH, HEIGHT));
    }

    @Override
    protected void setupScenes() {
        var selectionScene = new SelectionScene(this);
        addScene(SCENE_SELECTION, selectionScene);
        var textEntitiesScene = new TextEntitiesScene(this);
        addScene(SCENE_TEXT_ENTITIES, textEntitiesScene);
        var spriteEntitiesScene = new SpriteEntitiesScene(this);
        addScene(SCENE_SPRITE_ENTITIES, spriteEntitiesScene);
        var shapeEntitiesScene = new ShapeEntitiesScene(this);
        addScene(SCENE_SHAPE_ENTITIES, shapeEntitiesScene);
        var dynamicSceneWithTimers = new DynamicSceneWithTimer(this);
        addScene(SCENE_WITH_TIMERS, dynamicSceneWithTimers);
        var sceneWithEntityMaps = new TileMapScene(this);
        addScene(SCENE_WITH_ENTITYMAPS, sceneWithEntityMaps);
        var sceneWithSpawners = new RideTheLightningScene(this);
        addScene(SCENE_WITH_SPAWNERS, sceneWithSpawners);
        var distance = new TheDistanceScene(this);
        addScene(SCENE_DISTANCE, distance);
    }

    public void setActiveScene(int scene) {
        super.setActiveScene(scene);
    }
}
