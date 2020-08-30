package nl.han.showcase.scenes.distance;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import com.github.hanyaeger.api.engine.scenes.EntitySpawnerContainer;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.distance.entities.*;

public class TheDistanceScene extends DynamicScene implements EntitySpawnerContainer {

    private YaegerShowCase showCase;
    private RocketSpawner rocketSpawner;

    public TheDistanceScene(YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);

        // We instantiate the rocketspawner at this early stage, so we can pass it
        // to the antiAircraftLauncher.
        rocketSpawner = new RocketSpawner(new Coordinate2D(getWidth() / 2, getHeight()));
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(showCase, new Coordinate2D(20, getHeight() - 30));
        addEntity(backButton);

        var spaceShip = new SpaceShip(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        spaceShip.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addEntity(spaceShip);

        var antiAircraftBase = new AntiAircraftBase(new Coordinate2D(getWidth() / 2, getHeight()));
        addEntity(antiAircraftBase);

        var antiAircraftLauncher = new AnitAircraftLauncer(new Coordinate2D(getWidth() / 2, getHeight()), spaceShip, rocketSpawner);
        addEntity(antiAircraftLauncher);

        var distanceText = new DistanceText(new Coordinate2D(getWidth() / 2 + 60, getHeight() - 60), antiAircraftBase, spaceShip);
        addEntity(distanceText);

        var angleText = new AngleText(new Coordinate2D(getWidth() / 2 + 60, getHeight() - 40), antiAircraftBase, spaceShip);
        addEntity(angleText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(rocketSpawner);
    }
}
