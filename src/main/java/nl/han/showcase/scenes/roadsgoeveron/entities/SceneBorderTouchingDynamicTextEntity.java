package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.text.DynamicTextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneBorderTouchingDynamicTextEntity extends DynamicTextEntity implements SceneBorderTouchingWatcher {

    public static final String TEXT = "SceneBorderTouching";

    public SceneBorderTouchingDynamicTextEntity(final Coordinate2D position) {
        super(position, TEXT);
        setFill(Color.SILVER);
        setFont(Font.font("arial", FontWeight.BOLD, 30));
        setMotion(6, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setFill(Color.SILVER);
        } else {
            setFill(Color.TEAL);
        }
        changeDirection(180);
    }
}
