package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.circle.CircleEntity;
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
