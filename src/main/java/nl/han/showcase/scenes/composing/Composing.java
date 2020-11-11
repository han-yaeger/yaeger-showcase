package nl.han.showcase.scenes.composing;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.composing.entities.blackboard.Blackboard;
import nl.han.showcase.scenes.composing.entities.car.Car;
import nl.han.showcase.scenes.composing.entities.car.wheel.Wheel;

public class Composing extends ShowCaseScene {

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

        var topLeftWheel = new Wheel(new Coordinate2D(0, 0));
        addEntity(topLeftWheel);

        var blackboard = new Blackboard(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        blackboard.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(blackboard);

        var car = new Car(new Coordinate2D(getWidth() / 2, getHeight() - 150));
        car.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(car);
    }
}
