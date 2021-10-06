package nl.han.showcase.scenes.composing;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.impl.TextEntity;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.composing.entities.PinkTree;
import nl.han.showcase.scenes.composing.entities.blackboard.ShapesInShapes;
import nl.han.showcase.scenes.composing.entities.car.Car;
import nl.han.showcase.scenes.composing.entities.car.wheel.Wheel;
import nl.han.showcase.scenes.composing.entities.newtoniancircle.NewtonianCircleComposite;
import nl.han.showcase.scenes.composing.entities.newtoniancircle.RectangularFloor;
import nl.han.showcase.scenes.composing.entities.waterworld.hanny.Hanny;
import nl.han.showcase.scenes.composing.entities.waterworld.swordfish.SwordFish;

/**
 * This {@link com.github.hanyaeger.api.scenes.DynamicScene} will show different instances of
 * {@link com.github.hanyaeger.api.entities.CompositeEntity} and
 * {@link com.github.hanyaeger.api.entities.DynamicCompositeEntity}.
 */
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

        var shapeInShapes = new ShapesInShapes(new Coordinate2D(getWidth() / 2, MARGIN));
        shapeInShapes.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(shapeInShapes);

        placeNewtonianCircle();

        var hanny = new Hanny(new Coordinate2D(getWidth() / 2, 400));
        addEntity(hanny);

        var swordFish = new SwordFish(new Coordinate2D(getWidth() / 2, 400));
        addEntity(swordFish);

        var car = new Car(new Coordinate2D(getWidth() / 2, getHeight() - 50));
        car.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        car.setViewOrder(2);
        addEntity(car);

        var tree = new PinkTree(new Coordinate2D(10, getHeight()));
        tree.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addEntity(tree);
    }

    public void placeNewtonianCircle() {
        var textCircles = new TextEntity(new Coordinate2D(getWidth() - 260, MARGIN), "Use the Z and X to move the circle left and right");
        textCircles.setFill(YaegerShowCase.HAN_RED);
        addEntity(textCircles);

        var newtonianCircleComposite = new NewtonianCircleComposite(new Coordinate2D(getWidth() - 150, 20), this);
        addEntity(newtonianCircleComposite);

        var rectangularFloor = new RectangularFloor(new Coordinate2D(getWidth() - 100, 220));
        rectangularFloor.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(rectangularFloor);
    }
}
