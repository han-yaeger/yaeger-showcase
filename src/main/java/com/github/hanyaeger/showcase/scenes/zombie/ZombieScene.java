package com.github.hanyaeger.showcase.scenes.zombie;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.showcase.scenes.zombie.entities.*;
import com.github.hanyaeger.showcase.shared.buttons.BackButton;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.ShowCaseScene;
import com.github.hanyaeger.showcase.shared.HanLogoHeader;

public class ZombieScene extends ScrollableDynamicScene implements UpdateExposer {


    protected YaegerShowCase showCase;

    private Zombie zombie;

    public ZombieScene(final YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/dungeon.png");

        // The size is the same as the image.
        setSize(new Size(2223, 698));
    }

    @Override
    public void setupEntities() {

        // Since the background is lacking the HAN logo, we add it with stickyOnViewPort `true`
        addEntity(new HanLogoHeader(), true);

        // Since the backbutton should be visible at all times, we add it with stickyOnViewPort `true`
        var backButton = new BackButton(getViewportHeight() - ShowCaseScene.BOTTOM_MARGIN, showCase);
        addEntity(backButton, true);

//        setupBackground();

//        placeRugbyBallsWithAllAnchorPoints();
//
//        var blueBall = new BlueBallBouncing(new Coordinate2D(100, 200));
//        addEntity(blueBall);
//
//        var greenBall1 = new GreenBall(new Coordinate2D(getWidth() / 2, 280), 5, Direction.LEFT.getValue());
//        greenBall1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(greenBall1);
//
//        var greenBall2 = new GreenBall(new Coordinate2D(20, 280), 4, Direction.RIGHT.getValue());
//        greenBall2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(greenBall2);
//
//        var greenBall3 = new GreenBall(new Coordinate2D(getWidth() - 20, 280), 6, Direction.RIGHT.getValue());
//        greenBall3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(greenBall3);
//
//        var circlingBlue = new BlueBallCircling(new Coordinate2D(50, 430));
//        addEntity(circlingBlue);
//
//        var bouncingYellow = new BouncingYellow(new Coordinate2D(260, 500));
//        addEntity(bouncingYellow);
//
//        var walking = new Walking(new Coordinate2D(50, 500));
//        addEntity(walking);

        var bat = new Bat(new Coordinate2D(180, 65));
        addEntity(bat);

        zombie = new com.github.hanyaeger.showcase.scenes.zombie.entities.Zombie(new Coordinate2D(190, 585));
        addEntity(zombie);

        for (int i = -15; i <= 2210; i = i + 445) {
            var torch = new Torch(new Coordinate2D(i, 500));
            addEntity(torch);
        }
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
     * To center the viewport around the Player, we let this class implement the interface {@link UpdateExposer},
     * which adds the method {@link UpdateExposer#explicitUpdate(long)} that is called during each Game World Update.
     * <p>
     * During these GWU's we use the location of the Player to set the scroll position.
     *
     * @param timestamp the current time as a timestamp
     */
    @Override
    public void explicitUpdate(final long timestamp) {
        setHorizontalScrollPosition(zombie.getAnchorLocation().getX() / getWidth());
    }
}
