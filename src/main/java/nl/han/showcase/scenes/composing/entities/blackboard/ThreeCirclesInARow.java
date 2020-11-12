package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.CompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;

public class ThreeCirclesInARow extends CompositeEntity {

    public ThreeCirclesInARow(Coordinate2D initialLocation) {
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
