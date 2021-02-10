package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.engine.Effectable;
import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

public class CustomColorEntity extends RectangleEntity {
    public CustomColorEntity(Coordinate2D location, Size size) {
        super(location, size);
    }

    public CustomColorEntity(Coordinate2D location, Size size, Color color) {
        this(location, size);
        setFill(color);
    }
}
