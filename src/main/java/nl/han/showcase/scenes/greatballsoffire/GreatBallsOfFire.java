package nl.han.showcase.scenes.greatballsoffire;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.YaegerEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.greatballsoffire.entities.*;

public class GreatBallsOfFire extends ShowCaseScene {

    public static final int PARALLAX_HEIGHT = 640;

    public GreatBallsOfFire(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        // Since this scene uses a parallax background, which is constructed by using DynamicSpriteEntities,
        // there is no need for a background image. So we just ensure it is set to the color black.
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {

        super.setupEntities();

        setupBackground();

        placeRugbyBallsWithAllAnchorPoints();

        var blueBall = new BlueBallBouncing(new Coordinate2D(100, 200));
        addEntity(blueBall);

        var greenBall1 = new GreenBall(new Coordinate2D(getWidth() / 2, 280), 5, Direction.LEFT.getValue());
        greenBall1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(greenBall1);

        var greenBall2 = new GreenBall(new Coordinate2D(20, 280), 4, Direction.RIGHT.getValue());
        greenBall2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(greenBall2);

        var greenBall3 = new GreenBall(new Coordinate2D(getWidth() - 20, 280), 6, Direction.RIGHT.getValue());
        greenBall3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(greenBall3);

        var circlingBlue = new BlueBallCircling(new Coordinate2D(50, 430));
        addEntity(circlingBlue);

        var bouncingYellow = new BouncingYellow(new Coordinate2D(260, 500));
        addEntity(bouncingYellow);

        var walking = new Walking(new Coordinate2D(50, 500));
        addEntity(walking);
    }

    private void setupBackground() {
        addEntity(new HanLogoHeader());
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_1.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 100, 1.75));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_2.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 101, 1.50));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_3.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 102, 1.25));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_4.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 103, 1.0));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_5.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 104, 0.75));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_6.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 105, 0.5));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_7.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 106, 0));
        addEntity(new ParallaxBackground("backgrounds/parallax_layer_8.png", new Coordinate2D(0, 58), new Size(this.getWidth() * 2, PARALLAX_HEIGHT), this, 107, 0));
    }

    private void placeRugbyBallsWithAllAnchorPoints() {

        var margin = 100d;

        var tl = new PinkBall(new Coordinate2D(margin, margin));
        addEntity(tl);

        var tc = new PinkBall(new Coordinate2D(getWidth() / 2, margin));
        tc.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(tc);

        var tr = new PinkBall(new Coordinate2D(getWidth() - margin, margin));
        tr.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(tr);

        var lc = new PinkBall(new Coordinate2D(margin, getHeight() / 2));
        lc.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addEntity(lc);

        var cc = new PinkBall(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        cc.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(cc);

        var rc = new PinkBall(new Coordinate2D(getWidth() - margin, getHeight() / 2));
        rc.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addEntity(rc);
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
}
