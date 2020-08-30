package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;

public class BackButton extends Button {

    public static final String BACK = "Back";

    public BackButton(final YaegerShowCase showCase, final Coordinate2D location) {
        super(location, BACK, showCase, YaegerShowCase.SCENE_SELECTION);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(Color.SNOW);
        setFont(Font.font("palatino", FontWeight.BOLD, 30));
    }
}
