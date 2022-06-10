package com.github.hanyaeger.showcase.scenes.shapeofyou;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.showcase.scenes.shapeofyou.entities.*;
import com.github.hanyaeger.showcase.shared.HanLogoHeader;
import javafx.scene.paint.Color;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.ShowCaseScene;

public class ShapeOfYouScene extends ShowCaseScene {

    public static final int PARALLAX_HEIGHT = 640;

    private static final double ROW_HEIGHT = 130;
    private static final double VERTICAL_MARGIN = 100;

    public static final Color YELLOW = Color.rgb(248, 228, 87);
    public static final Color ORANGE = Color.rgb(246, 170, 62);

    public ShapeOfYouScene(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        // No setup required. The background is done through the parallax.
    }

    @Override
    public void setupEntities() {
        super.setupEntities();
        setupBackground();

        var sun = new Sun(new Coordinate2D(getWidth() - VERTICAL_MARGIN, ROW_HEIGHT));
        sun.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        sun.setViewOrder(5);
        addEntity(sun);

        var sunHalo = new SunHalo(new Coordinate2D(getWidth() - VERTICAL_MARGIN, ROW_HEIGHT));
        sunHalo.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        sunHalo.setViewOrder(6);
        addEntity(sunHalo);

        var rect = new StaticRectangle(new Coordinate2D(VERTICAL_MARGIN, ROW_HEIGHT));
        rect.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(rect);

        var ellipse = new StaticEllipse(new Coordinate2D(getWidth() / 2, ROW_HEIGHT));
        ellipse.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ellipse);


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

    /**
     * Override the {@code protected} method in the superclass with a {@code public} version to change
     * the visibility. This way it is possible to add instances of {@link YaegerEntity} from outside this
     * instance.
     *
     * @param yaegerEntity The {@link YaegerEntity} that should be added to this
     *                     {@link com.github.hanyaeger.api.scenes.YaegerScene}
     */
    @Override
    public void addEntity(final YaegerEntity yaegerEntity) {
        super.addEntity(yaegerEntity);
    }

    private void setupBackground() {
        addEntity(new HanLogoHeader());
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_1.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 100, 1.1));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_2.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 101, 1.0));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_3.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 102, 0.9));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_4.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 103, 0.8));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_5.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 104, 0.7));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_6.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 105, 0.6));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_7.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 106, 0.5));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_8.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 107, 0.4));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_9.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 108, 0.3));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_10.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 109, 0.2));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_11.png", new Coordinate2D(0, 58), new Size(getWidth() * 2, PARALLAX_HEIGHT), this, 110, 0.1));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_12.png", new Coordinate2D(0, 58), new Size(getWidth(), PARALLAX_HEIGHT), this, 111, 0));
    }
}
