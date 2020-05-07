package nl.han.showcase.scenes.textentities.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.DynamicTextEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneBorderTouchingDynamicTextEntity extends DynamicTextEntity implements SceneBorderTouchingWatcher {

    public static final String TEXT = "SceneBorderTouching";

    public SceneBorderTouchingDynamicTextEntity(final Location position) {
        super(position, TEXT);
        setFill(Color.SILVER);
        setFont(Font.font("arial", FontWeight.BOLD, 30));
        setMotionTo(6, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setFill(Color.SILVER);
        } else {
            setFill(Color.TEAL);
        }
        changeDirectionBy(180);
    }
}
