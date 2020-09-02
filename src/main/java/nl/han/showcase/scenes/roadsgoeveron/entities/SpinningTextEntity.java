package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.DynamicTextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;

public class SpinningTextEntity extends DynamicTextEntity {

    public SpinningTextEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setText("Spinning");
        setFill(YaegerShowCase.HAN_RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setRotationSpeed(-5);
    }
}
