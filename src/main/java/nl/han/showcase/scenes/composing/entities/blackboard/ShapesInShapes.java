package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import nl.han.showcase.YaegerShowCase;

/**
 * A demonstration of how multiple compositions can be combined within another composition.
 */
public class ShapesInShapes extends CompositeEntity {

    public static final int TEXT_HEIGHT = 40;

    public ShapesInShapes(final Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var textCircles = new TextEntity(new Coordinate2D(0, 0), "Click the circles below to remove them.");
        textCircles.setFill(YaegerShowCase.HAN_RED);
        addEntity(textCircles);

        var textSquare = new TextEntity(new Coordinate2D(0, 15), "Click the Square to remove the square and all remaining circles");
        textSquare.setFill(YaegerShowCase.HAN_RED);
        addEntity(textSquare);

        var board = new Board(new Coordinate2D(0, TEXT_HEIGHT), this);
        addEntity(board);

        var rowOne = new ThreeCirclesInARow(new Coordinate2D(0, TEXT_HEIGHT));
        addEntity(rowOne);

        var rowTwo = new ThreeCirclesInARow(new Coordinate2D(0, TEXT_HEIGHT + 2 * Circle.RADIUS));
        addEntity(rowTwo);

        var rowThree = new ThreeCirclesInARow(new Coordinate2D(0, TEXT_HEIGHT + 4 * Circle.RADIUS));
        addEntity(rowThree);
    }
}
