package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.paint.Color;

public class StaticCircle extends CircleEntity {

    public StaticCircle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(40);
        setFill(Color.WHITE);
        setStrokeColor(Color.rgb(188, 13, 93));
        setStrokeWidth(3);
    }
}
