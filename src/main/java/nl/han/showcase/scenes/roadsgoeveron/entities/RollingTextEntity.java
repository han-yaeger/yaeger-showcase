package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.DynamicTextEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;

public class RollingTextEntity extends DynamicTextEntity implements SceneBorderTouchingWatcher {

    public RollingTextEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setText("Rolling");
        setFill(YaegerShowCase.HAN_RED);
        setMotionTo(5, Direction.LEFT.getValue());
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setRotationSpeed(4);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirectionBy(180);
        setRotationSpeed(-1 * getRotationSpeed());
    }
}
