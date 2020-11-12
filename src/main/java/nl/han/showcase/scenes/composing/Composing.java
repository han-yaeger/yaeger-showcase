package nl.han.showcase.scenes.composing;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.composing.entities.blackboard.ShapesInShapes;
import nl.han.showcase.scenes.composing.entities.car.Car;
import nl.han.showcase.scenes.composing.entities.car.wheel.Wheel;
import nl.han.showcase.scenes.composing.entities.waterworld.hanny.Hanny;
import nl.han.showcase.scenes.composing.entities.waterworld.swordfish.SwordFish;

public class Composing extends ShowCaseScene {

    private static final Double MARGIN = 10d;

    public Composing(final YaegerShowCase yaegerShowCase) {
        super(yaegerShowCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/vortex.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var topLeftWheel = new Wheel(new Coordinate2D(MARGIN, MARGIN));
        addEntity(topLeftWheel);

        var shapeInShapes = new ShapesInShapes(new Coordinate2D(MARGIN, 90));
        shapeInShapes.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(shapeInShapes);

        var hanny = new Hanny(new Coordinate2D(MARGIN, 400));
        addEntity(hanny);

        var swordFish = new SwordFish(new Coordinate2D(getWidth() / 2, 400));
        addEntity(swordFish);

        var car = new Car(new Coordinate2D(getWidth() / 2, getHeight() - 100));
        car.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(car);
    }
}
