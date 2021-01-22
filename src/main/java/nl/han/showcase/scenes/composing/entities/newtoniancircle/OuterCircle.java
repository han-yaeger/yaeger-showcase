package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class OuterCircle extends CircleEntity {

    public static final double RADIUS = 30;

    public OuterCircle(Coordinate2D initialPosition) {
        super(initialPosition);

        setRadius(RADIUS);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }
}
