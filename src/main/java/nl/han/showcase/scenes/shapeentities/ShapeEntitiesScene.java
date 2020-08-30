package nl.han.showcase.scenes.shapeentities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.shapeentities.entities.*;

public class ShapeEntitiesScene extends ShowCaseScene {

    private YaegerShowCase showCase;

    public ShapeEntitiesScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/milky-way.jpg");
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(showCase, new Coordinate2D(20, getHeight() - 30));
        addEntity(backButton);

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

    @Override
    public YaegerShowCase getShowCase() {
        return showCase;
    }
}
