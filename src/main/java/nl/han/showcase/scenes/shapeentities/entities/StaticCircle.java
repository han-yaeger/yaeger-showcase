package nl.han.showcase.scenes.shapeentities.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

public class StaticCircle extends CircleEntity {

    public StaticCircle(Location initialPosition) {
        super(initialPosition);
        setRadius(40);
        setFill(Color.LIGHTSEAGREEN);
        setStrokeColor(Color.DARKKHAKI);
        setStrokeWidth(3);
    }
}
