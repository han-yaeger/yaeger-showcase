package nl.han.showcase.scenes.composing;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.composing.entities.wheel.Spoke;
import nl.han.showcase.scenes.composing.entities.wheel.Wheel;

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
        topLeftWheel.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(topLeftWheel);

//        var topRightWheel = new Wheel(new Coordinate2D(0, 0));
//        topRightWheel.setAnchorPoint(AnchorPoint.TOP_RIGHT);
//        addEntity(topRightWheel);
//
//        var bottomRightWheel = new Wheel(new Coordinate2D(0, 0));
//        bottomRightWheel.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
//        addEntity(bottomRightWheel);

        var bottomLeftWheel = new Wheel(new Coordinate2D(0, 0));
        bottomLeftWheel.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addEntity(bottomLeftWheel);
    }
}
