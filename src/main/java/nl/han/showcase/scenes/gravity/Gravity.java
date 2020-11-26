package nl.han.showcase.scenes.gravity;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMapContainer;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.gravity.entities.Roots;
import nl.han.showcase.scenes.gravity.entities.FallCollider;
import nl.han.showcase.scenes.gravity.entities.GroundCollider;
import nl.han.showcase.scenes.gravity.maps.GroundMap;
import nl.han.showcase.scenes.gravity.entities.GreenNewtonianBall;
import nl.han.showcase.scenes.gravity.maps.TotemMap;

/**
 * Yaeger supports simple physics through the {@link com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian}
 * interface. This interface should be implemented by dynamic Entity to change its behaviour by including gravity and friction.
 * Where a true physics implementation would mean the whole {@link com.github.hanyaeger.api.engine.scenes.YaegerScene} should
 * follow the rules of physics, this implementation can be applied to certain entities.
 * <p>
 * In this scene we provide an example, where a game character implements the {@link com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian}
 * interface. The rest of the scene is based on several implementations of {@link com.github.hanyaeger.api.engine.entities.tilemap.TileMap}.
 * <p>
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

        spawnNewBall();

        setupRoots();
        setupColliders();
    }

    public void spawnNewBall() {
        var greenNewtonianBall = new GreenNewtonianBall(new Coordinate2D(10, 200), this);
        addEntity(greenNewtonianBall);
    }

    private void setupRoots() {
        var roots1 = new Roots(new Coordinate2D(430, 495));
        addEntity(roots1);

        var roots2 = new Roots(new Coordinate2D(610, 405));
        addEntity(roots2);

        var roots3 = new Roots(new Coordinate2D(670, 405));
        addEntity(roots3);
    }

    private void setupColliders() {
        var groundCollider1 = new GroundCollider(new Coordinate2D(0, 610));
        groundCollider1.setWidth(335);
        addEntity(groundCollider1);

        var fallCollider1 = new FallCollider(new Coordinate2D(345, 600));
        fallCollider1.setWidth(30);
        addEntity(fallCollider1);

        var groundCollider2 = new GroundCollider(new Coordinate2D(412, 425));
        groundCollider2.setWidth(80);
        addEntity(groundCollider2);

        var fallCollider2 = new FallCollider(new Coordinate2D(370, 415));
        fallCollider2.setWidth(30);
        addEntity(fallCollider2);

        var groundCollider3 = new GroundCollider(new Coordinate2D(500, 330));
        groundCollider3.setWidth(245);
        addEntity(groundCollider3);

        var fallCollider3 = new FallCollider(new Coordinate2D(458, 320));
        fallCollider3.setWidth(30);
        addEntity(fallCollider3);

        var fallCollider4 = new FallCollider(new Coordinate2D(757, 320));
        fallCollider4.setWidth(30);
        addEntity(fallCollider4);

        var groundCollider4 = new GroundCollider(new Coordinate2D(getWidth(), 155));
        groundCollider4.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        groundCollider4.setWidth(120);
        addEntity(groundCollider4);

        var fallCollider5 = new FallCollider(new Coordinate2D(getWidth() - 125, 150));
        fallCollider5.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        fallCollider5.setWidth(30);
        addEntity(fallCollider5);
    }

    @Override
    public void setupTileMaps() {
        var groundMap = new GroundMap();
        addTileMap(groundMap);

        var totemMap = new TotemMap(new Coordinate2D(200, 610), new Size(40, 160));
        totemMap.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addTileMap(totemMap);
    }
}
