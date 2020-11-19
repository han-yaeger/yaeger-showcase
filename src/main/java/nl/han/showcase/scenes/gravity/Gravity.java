package nl.han.showcase.scenes.gravity;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.gravity.entities.FloorMap;
import nl.han.showcase.scenes.greatballsoffire.entities.*;

/**
 * The sprites from this scene are taken from: http://blog.spiralgraphics.biz/2011/01/mystery-forest-tile-set.html
 */
public class Gravity extends ShowCaseScene implements TileMapContainer {

    public Gravity(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/forrest.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var greenNewtonianBall = new GreenNewtonianBall(new Coordinate2D(200, 200));
        addEntity(greenNewtonianBall);
    }

    @Override
    public void setupTileMaps() {
        var foorMap = new FloorMap();
        addTileMap(foorMap);
    }
}
