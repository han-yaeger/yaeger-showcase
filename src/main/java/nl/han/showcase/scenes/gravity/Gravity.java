package nl.han.showcase.scenes.gravity;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.YaegerEntity;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.gravity.entities.*;
import nl.han.showcase.scenes.gravity.tilemaps.GroundTileMap;

import java.util.ArrayList;
import java.util.List;


/**
 * Yaeger supports simple physics through the {@link com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian}
 * interface. This interface should be implemented by Dynamic Entities to change their behaviour by including gravity and friction.
 * Where a true physics implementation would mean the whole {@link com.github.hanyaeger.api.engine.scenes.YaegerScene} should
 * follow the rules of physics, this implementation can be applied to certain entities.
 * <p>
 * The sprites from this scene are taken from: http://blog.spiralgraphics.biz/2011/01/mystery-forest-tile-set.html
 */
public class Gravity extends ShowCaseScene implements TileMapContainer {

    private static final double HEIGHT = 50d;

    private final List<YaegerEntity> entities = new ArrayList<>();

    public Gravity(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gravity.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var resetButton = new ResetButton(new Coordinate2D(100, getHeight() - BOTTOM_MARGIN), this);
        addEntity(resetButton);

        createEntities();

        entities.forEach(entity -> addEntity(entity));
    }

    public void resetEntities() {
        entities.forEach(entity -> entity.remove());
        entities.clear();

        createEntities();
        entities.forEach(entity -> addEntity(entity));
    }

    private void createEntities() {

        var verticalWithFriction = new Blue(new Coordinate2D(20, 20));
        verticalWithFriction.setGravitationalPull(false);
        verticalWithFriction.setMotion(4, Direction.RIGHT);
        entities.add(verticalWithFriction);

        var blueLowFriction = new Blue(new Coordinate2D(getWidth() / 10, HEIGHT));
        blueLowFriction.setFrictionConstant(0.05);
        entities.add(blueLowFriction);

        var blueLowGravity = new Blue(new Coordinate2D(2 * (getWidth() / 10), HEIGHT));
        blueLowGravity.setGravityConstant(0.01);
        entities.add(blueLowGravity);

        var blueDefault = new Blue(new Coordinate2D(3 * (getWidth() / 10), HEIGHT));
        entities.add(blueDefault);

        var blueHighGravity = new Blue(new Coordinate2D(4 * (getWidth() / 10), HEIGHT));
        blueHighGravity.setGravityConstant(0.1);
        entities.add(blueHighGravity);

        var blueHighFriction = new Blue(new Coordinate2D(5 * (getWidth() / 10), HEIGHT));
        blueHighFriction.setFrictionConstant(0.5);
        entities.add(blueHighFriction);

        var greenLowFriction = new Green(new Coordinate2D(6 * (getWidth() / 10), HEIGHT));
        greenLowFriction.setFrictionConstant(0.001);
        entities.add(greenLowFriction);

        var greenDefaultFriction = new Green(new Coordinate2D(7 * (getWidth() / 10), HEIGHT));
        entities.add(greenDefaultFriction);

        var greenHighFriction = new Green(new Coordinate2D(8 * (getWidth() / 10), HEIGHT));
        greenHighFriction.setFrictionConstant(0.5);
        entities.add(greenHighFriction);

        var pink = new Pink(new Coordinate2D(9 * (getWidth() / 10), HEIGHT));
        entities.add(pink);
    }

    @Override
    public void setupTileMaps() {
        var groundScreenMap = new GroundTileMap();
        addTileMap(groundScreenMap);
    }
}