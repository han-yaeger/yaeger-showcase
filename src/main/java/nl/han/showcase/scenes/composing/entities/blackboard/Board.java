package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

public class Board extends RectangleEntity {

    public Board(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(200);
        setHeight(100);
        setFill(Color.BLACK);
    }
}
