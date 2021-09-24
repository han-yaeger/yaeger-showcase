package nl.han.showcase.scenes.selection;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.shared.buttons.QuitButton;
import nl.han.showcase.shared.buttons.SelectionButton;

/**
 * A {@link StaticScene} that only contains the menu for selecting the
 * {@link StaticScene}. Besides buttons,
 * which are just instances of {@link TextEntity}, this {@link StaticScene}
 * also listens to the keyboard, by implementing the {@link com.github.hanyaeger.api.userinput.KeyListener interface.
 */
public class SelectionScene extends StaticScene {

    // To align the buttons on the screen we create a constant for the left margin.
    public static final double LEFT_MARGIN = 34;

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

        var roadsGoEverOn = new SelectionButton(150, YaegerShowCase.SCENE_ROADS_GO_EVER_ON_TITLE, showCase, YaegerShowCase.SCENE_ROADS_GO_EVER_ON);
        addEntity(roadsGoEverOn);

        var greatBallsOfFire = new SelectionButton(200, YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE_TITLE, showCase, YaegerShowCase.SCENE_GREAT_BALLS_OF_FIRE);
        addEntity(greatBallsOfFire);

        var shapeOfYou = new SelectionButton(250, YaegerShowCase.SCENE_SHAPE_TITLE, showCase, YaegerShowCase.SCENE_SHAPE);
        addEntity(shapeOfYou);

        var composing = new SelectionButton(300, YaegerShowCase.SCENE_COMPOSING_TITLE, showCase, YaegerShowCase.SCENE_COMPOSING);
        addEntity(composing);

        var time = new SelectionButton(350, YaegerShowCase.SCENE_TIME_TITLE, showCase, YaegerShowCase.SCENE_TIME);
        addEntity(time);

        var maps = new SelectionButton(400, YaegerShowCase.SCENE_MAPS_TITLE, showCase, YaegerShowCase.SCENE_MAPS);
        addEntity(maps);

        var rideTheLightning = new SelectionButton(450, YaegerShowCase.SCENE_RIDE_THE_LIGHTNING_TITLE, showCase, YaegerShowCase.SCENE_RIDE_THE_LIGHTNING);
        addEntity(rideTheLightning);

        var distanceScene = new SelectionButton(500, YaegerShowCase.SCENE_DISTANCE_TITLE, showCase, YaegerShowCase.SCENE_DISTANCE);
        addEntity(distanceScene);

        var gravityScene = new SelectionButton(550, YaegerShowCase.SCENE_GRAVITY_TITLE, showCase, YaegerShowCase.SCENE_GRAVITY);
        addEntity(gravityScene);

        var scrollingScene = new SelectionButton(600, YaegerShowCase.SCENE_SCROLLING_TITLE, showCase, YaegerShowCase.SCENE_SCROLLING);
        addEntity(scrollingScene);
    }
}
