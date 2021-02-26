package nl.han.showcase.scenes.gravity;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.YaegerEntity;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.gravity.entities.*;
import nl.han.showcase.scenes.gravity.tilemaps.GroundTileMap;
import nl.han.showcase.scenes.gravity.tilemaps.StairsTileMap;

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

        entities.forEach(this::addEntity);
    }

    public void resetEntities() {
        entities.forEach(YaegerEntity::remove);
        entities.clear();

        createEntities();
        entities.forEach(this::addEntity);
    }

    private void createEntities() {

        var verticalWithFriction = new Blue(new Coordinate2D(20, 20));
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

        var stairBouncer = new Green(new Coordinate2D(6 * (getWidth() / 10), HEIGHT));
        stairBouncer.setMotion(1, Direction.RIGHT);
        stairBouncer.setFrictionConstant(0.001);
        entities.add(stairBouncer);

        var pink = new Pink(new Coordinate2D(9 * (getWidth() / 10), HEIGHT));
        entities.add(pink);
    }

    @Override
    public void setupTileMaps() {
        var groundScreenMap = new GroundTileMap();
        addTileMap(groundScreenMap);

        var stairsMap = new StairsTileMap(new Coordinate2D(getWidth() - 100, getHeight() / 2), new Size(300, 300));
        stairsMap.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addTileMap(stairsMap);
    }
}
