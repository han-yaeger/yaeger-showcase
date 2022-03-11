package com.github.hanyaeger.showcase.scenes.selection;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.shared.buttons.QuitButton;
import com.github.hanyaeger.showcase.shared.buttons.SelectionButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A {@link StaticScene} that only contains the menu for selecting the
 * {@link StaticScene}. Besides buttons,
 * which are just instances of {@link TextEntity}, this {@link StaticScene}
 * also listens to the keyboard, by implementing the {@link com.github.hanyaeger.api.userinput.KeyListener interface.
 */
public class SelectionScene extends StaticScene {

    // To align the buttons on the screen we create a constant for the left margin.
    public static final double LEFT_MARGIN = 34;

    private static final double DELTA_Y = 40;

    private static final String TEXT_PLEASE_SELECT = "PLEASE SELECT A SCENE:";

    private final YaegerShowCase showCase;

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

        // This line of text is a simple StaticTextEntity and can therefore just be instantiated
        // and added to the Scene.
        var select = new TextEntity(new Coordinate2D(LEFT_MARGIN, 95), TEXT_PLEASE_SELECT);
        select.setFill(Color.BLACK);
        select.setFont(Font.font("Roboto", FontWeight.BOLD, 23));
        addEntity(select);

        var y = 150D;

        var roadsGoEverOn = new SelectionButton(y, YaegerShowCase.SCENE_ROADS_GO_EVER_ON_TITLE, showCase, YaegerShowCase.SCENE_ROADS_GO_EVER_ON);
        addEntity(roadsGoEverOn);

        y += DELTA_Y;

        var greatBallsOfFire = new SelectionButton(y, YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE_TITLE, showCase, YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE);
        addEntity(greatBallsOfFire);

        y += DELTA_Y;

        var shapeOfYou = new SelectionButton(y, YaegerShowCase.SCENE_SHAPE_TITLE, showCase, YaegerShowCase.SCENE_SHAPE);
        addEntity(shapeOfYou);

        y += DELTA_Y;

        var composing = new SelectionButton(y, YaegerShowCase.SCENE_COMPOSING_TITLE, showCase, YaegerShowCase.SCENE_COMPOSING);
        addEntity(composing);

        y += DELTA_Y;

        var time = new SelectionButton(y, YaegerShowCase.SCENE_TIME_TITLE, showCase, YaegerShowCase.SCENE_TIME);
        addEntity(time);

        y += DELTA_Y;

        var maps = new SelectionButton(y, YaegerShowCase.SCENE_MAPS_TITLE, showCase, YaegerShowCase.SCENE_MAPS);
        addEntity(maps);

        y += DELTA_Y;

        var rideTheLightning = new SelectionButton(y, YaegerShowCase.SCENE_RIDE_THE_LIGHTNING_TITLE, showCase, YaegerShowCase.SCENE_RIDE_THE_LIGHTNING);
        addEntity(rideTheLightning);

        y += DELTA_Y;

        var distanceScene = new SelectionButton(y, YaegerShowCase.SCENE_DISTANCE_TITLE, showCase, YaegerShowCase.SCENE_DISTANCE);
        addEntity(distanceScene);

        y += DELTA_Y;

        var gravityScene = new SelectionButton(y, YaegerShowCase.SCENE_GRAVITY_TITLE, showCase, YaegerShowCase.SCENE_GRAVITY);
        addEntity(gravityScene);

        y += DELTA_Y;

        var scrollingScene = new SelectionButton(y, YaegerShowCase.SCENE_SCROLLING_TITLE, showCase, YaegerShowCase.SCENE_SCROLLING);
        addEntity(scrollingScene);
    }
}
