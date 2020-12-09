package nl.han.showcase.scenes.gravity;

import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.gravity.tilemaps.GroundTileMap;
import nl.han.showcase.scenes.mapsandlegends.tilemaps.FullScreenTileMap;


/**
 * Yaeger supports simple physics through the {@link com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian}
 * interface. This interface should be implemented by Dynamic Entities to change their behaviour by including gravity and friction.
 * Where a true physics implementation would mean the whole {@link com.github.hanyaeger.api.engine.scenes.YaegerScene} should
 * follow the rules of physics, this implementation can be applied to certain entities.
 * <p>
 * The sprites from this scene are taken from: http://blog.spiralgraphics.biz/2011/01/mystery-forest-tile-set.html
 */
public class Gravity extends ShowCaseScene implements TileMapContainer {

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
    }

    @Override
    public void setupTileMaps() {
        var groundScreenMap = new GroundTileMap();
        addTileMap(groundScreenMap);
    }
}
