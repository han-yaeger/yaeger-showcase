package nl.han.showcase.scenes.shapeofyou;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.shapeofyou.entities.*;

public class ShapeOfYouScene extends ShowCaseScene {

    private static final double ROW_HEIGHT = 130;
    private static final double VERTICAL_MARGIN = 100;

    public static final Color YELLOW = Color.rgb(248, 228, 87);
    public static final Color ORANGE = Color.rgb(246, 170, 62);

    public ShapeOfYouScene(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/stars.jpg", false);
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var rect = new StaticRectangle(new Coordinate2D(VERTICAL_MARGIN, ROW_HEIGHT));
        rect.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(rect);

        var ellipse = new StaticEllipse(new Coordinate2D(getWidth() / 2, ROW_HEIGHT));
        ellipse.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ellipse);

        var circle = new StaticCircle(new Coordinate2D(getWidth() - VERTICAL_MARGIN, ROW_HEIGHT));
        circle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(circle);

        var timedDynamicRectangle = new TimedDynamicRectangle(new Coordinate2D(VERTICAL_MARGIN, 2 * ROW_HEIGHT));
        timedDynamicRectangle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(timedDynamicRectangle);

        var updatingCircle = new UpdatingCircle(new Coordinate2D(getWidth() / 2, 2 * ROW_HEIGHT));
        updatingCircle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(updatingCircle);

        var movingUpdatedCircle = new MovingUpdatingCircle(new Coordinate2D(VERTICAL_MARGIN, 3 * ROW_HEIGHT));
        movingUpdatedCircle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(movingUpdatedCircle);

        var dynamicRectangle = new DynamicRectangle(new Coordinate2D(getWidth() - VERTICAL_MARGIN, 3 * ROW_HEIGHT));
        dynamicRectangle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(dynamicRectangle);

        var collidingDynamicCircle = new CollidingDynamicCircle(new Coordinate2D(40, 4 * ROW_HEIGHT));
        collidingDynamicCircle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(collidingDynamicCircle);

        var collidingDynamicEllipse = new CollidingDynamicEllipse(new Coordinate2D(440, 4 * ROW_HEIGHT));
        collidingDynamicEllipse.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(collidingDynamicEllipse);
    }
}
