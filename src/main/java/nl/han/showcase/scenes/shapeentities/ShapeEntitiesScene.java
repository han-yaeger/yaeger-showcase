package nl.han.showcase.scenes.shapeentities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.shapeentities.entities.*;

public class ShapeEntitiesScene extends ShowCaseScene {

    private YaegerShowCase showCase;

    public ShapeEntitiesScene(YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/milky-way.jpg");
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(showCase, new Location(20, getHeight() - 30));
        addEntity(backButton);

        var rect = new StaticRectangle(new Location(40, 40));
        addEntity(rect);

        var circle = new StaticCircle(new Location(140, 40));
        addEntity(circle);

        var ellipse = new StaticEllipse(new Location(240, 40));
        addEntity(ellipse);

        var dynamicRectangle = new DynamicRectangle(new Location(40, 160));
        addEntity(dynamicRectangle);

        var dynamicCircle = new DynamicCircle(new Location(40, 260));
        addEntity(dynamicCircle);

        var dynamicEllipse = new DynamicEllipse(new Location(40, 360));
        addEntity(dynamicEllipse);

        var timedDynamicRectangle = new TimedDynamicRectangle(new Location(40, 460));
        addEntity(timedDynamicRectangle);
    }

    @Override
    public YaegerShowCase getShowCase() {
        return showCase;
    }
}
