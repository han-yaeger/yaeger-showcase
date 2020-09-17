package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class StaticCircle extends CircleEntity {

    public StaticCircle(final Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(40);
        setFill(Color.WHITE);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(3);
    }
}
