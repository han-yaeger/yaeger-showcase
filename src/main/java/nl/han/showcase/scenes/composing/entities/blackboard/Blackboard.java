package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.CompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;

public class Blackboard extends CompositeEntity {
    public Blackboard(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var board = new Board(new Coordinate2D(0, 0));
        addEntity(board);

        var circleTopLeft = new Circle(new Coordinate2D(0, 0));
        circleTopLeft.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(circleTopLeft);

        var circleTopRight = new Circle(new Coordinate2D(board.getWidth(), 0));
        circleTopRight.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(circleTopRight);

        var circleBottomLeft = new Circle(new Coordinate2D(0, board.getHeight()));
        circleBottomLeft.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addEntity(circleBottomLeft);

        var circleBottomRight = new Circle(new Coordinate2D(board.getWidth(), board.getHeight()));
        circleBottomRight.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addEntity(circleBottomRight);
    }
}
