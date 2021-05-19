package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.circle.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class OuterCircle extends CircleEntity {

    public static final double RADIUS = 30;

    public OuterCircle(final Coordinate2D initialPosition) {
        super(initialPosition);

        setRadius(RADIUS);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }
}
