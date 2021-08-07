package nl.han.showcase.scenes.mapsandlegends.entities.slider;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class Container extends RectangleEntity {

    public Container(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);
        setFill(Color.BLACK);
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setAnchorPoint(AnchorPoint.CENTER_LEFT);
    }
}
