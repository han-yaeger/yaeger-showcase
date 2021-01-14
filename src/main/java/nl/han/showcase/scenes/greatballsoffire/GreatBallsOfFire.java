package nl.han.showcase.scenes.greatballsoffire;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.greatballsoffire.entities.*;

public class GreatBallsOfFire extends ShowCaseScene {

    public GreatBallsOfFire(final YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/yellyfish.jpg");
    }

    @Override
    public void setupEntities() {

        super.setupEntities();

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

        var bl = new PinkBall(new Coordinate2D(margin, getHeight() - margin));
        bl.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addEntity(bl);

        var bc = new PinkBall(new Coordinate2D(getWidth() / 2, getHeight() - margin));
        bc.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addEntity(bc);

        var br = new PinkBall(new Coordinate2D(getWidth() - margin, getHeight() - margin));
        br.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addEntity(br);
    }
}
