package com.github.hanyaeger.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class ThreeCirclesInARow extends CompositeEntity {

    public ThreeCirclesInARow(final Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var circleOne = new Circle(new Coordinate2D(0, 0));
        circleOne.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(circleOne);

        var circleTwo = new Circle(new Coordinate2D(2 * Circle.RADIUS, 0));
        circleOne.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(circleTwo);

        var circleThree = new Circle(new Coordinate2D(4 * Circle.RADIUS, 0));
        circleOne.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(circleThree);
    }
}
