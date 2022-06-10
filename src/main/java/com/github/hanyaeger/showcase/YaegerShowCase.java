package com.github.hanyaeger.showcase;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.showcase.scenes.composing.Composing;
import com.github.hanyaeger.showcase.scenes.distance.TheDistanceScene;
import com.github.hanyaeger.showcase.scenes.gravity.Gravity;
import com.github.hanyaeger.showcase.scenes.zombie.ZombieScene;
import com.github.hanyaeger.showcase.scenes.mapsandlegends.MapsAndLegends;
import com.github.hanyaeger.showcase.scenes.ridethelightning.RideTheLightningScene;
import com.github.hanyaeger.showcase.scenes.scrollingstones.ScrollingStones;
import com.github.hanyaeger.showcase.scenes.shapeofyou.ShapeOfYouScene;
import javafx.scene.paint.Color;
import com.github.hanyaeger.showcase.scenes.time.Time;
import com.github.hanyaeger.showcase.scenes.selection.SelectionScene;
import com.github.hanyaeger.showcase.scenes.roadsgoeveron.RoadsGoEverOnScene;

/**
 * The {@link YaegerShowCase} demonstrates implementations of all features Yaeger provides. Use the code
 * to get insight into Yaeger's API and run the application to see the result.
 */
public class YaegerShowCase extends YaegerGame {

    // A constant that contains the name of the mp3 file that should be played throughout the ShowCase
    private static final String PACHELBEL = "audio/Pachelbel-canon-in-d.mp3";

    // A constant that contains the title of the game.
    private static final String GAME_TITLE = "Yaeger Show Case";

    // A constant that contains the red color that is used throughout the ShowCase.
    public static final Color HAN_RED = Color.rgb(229, 0, 85);

    // A constant that contains the dimensions of the ShowCase.
    private static final Size SIZE = new Size(1024, 698);

    // The ShowCase contains multiple Scenes to demonstrate all feature. Each of those
    // Scenes has an id and a title, expect the first scene, which is the one that can be
    // used for selecting other scenes.
    public static final int SCENE_SELECTION = 1;
    public static final int SCENE_ROADS_GO_EVER_ON = 2;
    public static final String SCENE_ROADS_GO_EVER_ON_TITLE = "Roads go ever on";
    public static final int SCENE_ZOMBIE = 3;
    public static final String SCENE_ZOMBIE_TITLE = "Zombie";
    public static final int SCENE_SHAPE = 4;
    public static final String SCENE_SHAPE_TITLE = "Shape of you";
    public static final int SCENE_COMPOSING = 5;
    public static final String SCENE_COMPOSING_TITLE = "Composing";
    public static final int SCENE_TIME = 6;
    public static final String SCENE_TIME_TITLE = "Time";
    public static final int SCENE_MAPS = 7;
    public static final String SCENE_MAPS_TITLE = "Maps and Legends";
    public static final int SCENE_RIDE_THE_LIGHTNING = 8;
    public static final String SCENE_RIDE_THE_LIGHTNING_TITLE = "Ride the Lightning";
    public static final int SCENE_DISTANCE = 9;
    public static final String SCENE_DISTANCE_TITLE = "The distance";
    public static final int SCENE_GRAVITY = 10;
    public static final String SCENE_GRAVITY_TITLE = "Gravity";
    public static final int SCENE_SCROLLING = 11;
    public static final String SCENE_SCROLLING_TITLE = "The Scrolling Stones";


    /**
     * The {@code #main(String[])} is the entry point of every Java Application. This {@code #main(String[])}
     * is used to call {@link YaegerGame#launch(String...)}, which starts the Game.
     *
     * @param args Commandline parameters that will be passed to Yaeger.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle(GAME_TITLE);
        setSize(SIZE);
        setBackgroundAudio(PACHELBEL);
        setBackgroundAudioVolume(0.1);
    }

    @Override
    public void setupScenes() {
        var selection = new SelectionScene(this);
        addScene(SCENE_SELECTION, selection);
        var roadsGoEverOn = new RoadsGoEverOnScene(this);
        addScene(SCENE_ROADS_GO_EVER_ON, roadsGoEverOn);
        var zombieScene = new ZombieScene(this);
        addScene(SCENE_ZOMBIE, zombieScene);
        var shapeOfYou = new ShapeOfYouScene(this);
        addScene(SCENE_SHAPE, shapeOfYou);
        var composing = new Composing(this);
        addScene(SCENE_COMPOSING, composing);
        var time = new Time(this);
        addScene(SCENE_TIME, time);
        var mapsAndLegends = new MapsAndLegends(this);
        addScene(SCENE_MAPS, mapsAndLegends);
        var rideTheLightning = new RideTheLightningScene(this);
        addScene(SCENE_RIDE_THE_LIGHTNING, rideTheLightning);
        var distance = new TheDistanceScene(this);
        addScene(SCENE_DISTANCE, distance);
        var gravity = new Gravity(this);
        addScene(SCENE_GRAVITY, gravity);
        var scrolling = new ScrollingStones(this);
        addScene(SCENE_SCROLLING, scrolling);
    }

    public void setActiveScene(int scene) {
        super.setActiveScene(scene);
    }
}
