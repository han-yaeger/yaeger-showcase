package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.text.DynamicTextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneBorderCrossingDynamicTextEntity extends DynamicTextEntity implements SceneBorderCrossingWatcher {

    public static final String TEXT = "SceneBorderCrossing";

    public SceneBorderCrossingDynamicTextEntity(final Coordinate2D position) {
        super(position, TEXT);
        setFill(Color.TURQUOISE);
        setFont(Font.font("palatino", FontWeight.BOLD, 30));
        setMotion(4, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setFill(Color.THISTLE);
        } else {
            setFill(Color.TURQUOISE);
        }

        changeDirection(180);
    }
}
