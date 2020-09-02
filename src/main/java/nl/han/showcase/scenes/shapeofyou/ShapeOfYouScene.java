package nl.han.showcase.scenes.shapeofyou;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.shapeofyou.entities.*;

public class ShapeOfYouScene extends ShowCaseScene {

    public ShapeOfYouScene(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/milky-way.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var rect = new StaticRectangle(new Coordinate2D(40, 40));
        addEntity(rect);

        var circle = new StaticCircle(new Coordinate2D(140, 40));
        addEntity(circle);

        var ellipse = new StaticEllipse(new Coordinate2D(240, 40));
        addEntity(ellipse);

        var dynamicRectangle = new DynamicRectangle(new Coordinate2D(40, 160));
        addEntity(dynamicRectangle);

        var dynamicCircle = new DynamicCircle(new Coordinate2D(40, 260));
        addEntity(dynamicCircle);

        var dynamicEllipse = new DynamicEllipse(new Coordinate2D(40, 360));
        addEntity(dynamicEllipse);

        var timedDynamicRectangle = new TimedDynamicRectangle(new Coordinate2D(40, 460));
        addEntity(timedDynamicRectangle);
    }
}
