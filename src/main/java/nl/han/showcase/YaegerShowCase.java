package nl.han.showcase;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.YaegerGame;
import javafx.scene.paint.Color;
import nl.han.showcase.scenes.distance.TheDistanceScene;
import nl.han.showcase.scenes.timers.DynamicSceneWithTimer;
import nl.han.showcase.scenes.entitymaps.TileMapScene;
import nl.han.showcase.scenes.selection.SelectionScene;
import nl.han.showcase.scenes.shapeofyou.ShapeOfYouScene;
import nl.han.showcase.scenes.ridethelightning.RideTheLightningScene;
import nl.han.showcase.scenes.greatballsoffire.GreatBallsOfFire;
import nl.han.showcase.scenes.roadsgoeveron.RoadsGoEverOnScene;

/**
 * The {@link YaegerShowCase} demonstrates implementations of all features Yaeger provides. Use the code
 * to get insight into Yaeger's API and run the application to see the result.
 */
public class YaegerShowCase extends YaegerGame {

    private static final String GAME_TITLE = "Yaeger Show Case";

    public static final Color HAN_RED = Color.rgb(229, 0, 85);

    private static final int WIDTH = 1024;
    private static final int HEIGHT = 698;

    public static final int SCENE_SELECTION = 1;
    public static final int SCENE_ROADS_GO_EVER_ON = 2;
    public static final String SCENE_ROADS_GO_EVER_ON_TITLE = "Roads go ever on";
    public static final int SCENE_GREAT_BALLS_OF_FIRE = 3;
    public static final String SCENE_GREAT_BALLS_OF_FIRE_TITLE = "Great balls of fire";
    public static final int SCENE_SHAPE = 4;
    public static final String SCENE_SHAPE_TITLE = "Shape of you";
    public static final int SCENE_TIME = 5;
    public static final String SCENE_TIME_TITLE = "Time";
    public static final int SCENE_MAPS = 6;
    public static final String SCENE_MAPS_TITLE = "Maps and Legends";
    public static final int SCENE_RIDE_THE_LIGHTNING = 7;
    public static final String SCENE_RIDE_THE_LIGHTNING_TITLE = "Ride the Lightning";
    public static final int SCENE_DISTANCE = 8;
    public static final String SCENE_DISTANCE_TITLE = "The distance";

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
        var textEntitiesScene = new RoadsGoEverOnScene(this);
        addScene(SCENE_ROADS_GO_EVER_ON, textEntitiesScene);
        var spriteEntitiesScene = new GreatBallsOfFire(this);
        addScene(SCENE_GREAT_BALLS_OF_FIRE, spriteEntitiesScene);
        var shapeEntitiesScene = new ShapeOfYouScene(this);
        addScene(SCENE_SHAPE, shapeEntitiesScene);
        var dynamicSceneWithTimers = new DynamicSceneWithTimer(this);
        addScene(SCENE_TIME, dynamicSceneWithTimers);
        var sceneWithEntityMaps = new TileMapScene(this);
        addScene(SCENE_MAPS, sceneWithEntityMaps);
        var sceneWithSpawners = new RideTheLightningScene(this);
        addScene(SCENE_RIDE_THE_LIGHTNING, sceneWithSpawners);
        var distance = new TheDistanceScene(this);
        addScene(SCENE_DISTANCE, distance);
    }

    public void setActiveScene(int scene) {
        super.setActiveScene(scene);
    }
}
