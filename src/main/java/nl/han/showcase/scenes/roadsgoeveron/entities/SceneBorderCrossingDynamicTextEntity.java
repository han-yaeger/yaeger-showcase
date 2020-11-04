package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.DynamicTextEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneBorderCrossingDynamicTextEntity extends DynamicTextEntity implements SceneBorderCrossingWatcher {

    public static final String TEXT = "SceneBorderCrossing";

    public SceneBorderCrossingDynamicTextEntity(final Coordinate2D position) {
        super(position, TEXT);
        setFill(Color.TURQUOISE);
        setFont(Font.font("palatino", FontWeight.BOLD, 30));
        setMotion(4, Direction.LEFT.getValue());
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
