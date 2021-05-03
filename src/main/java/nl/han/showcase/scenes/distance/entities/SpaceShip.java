package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.engine.userinput.MouseMovedListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

/**
 * A {@link SpaceShip} is just a simple {@link DynamicCircleEntity} that can move around the
 * {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}.
 * <p>
 * The interface {@link Collider} is used to registers collisions with a {@link Rocket}.
 */
public class SpaceShip extends DynamicCircleEntity implements MouseMovedListener, Collider {

    private static final double RADIUS = 20;

    public SpaceShip(Coordinate2D location) {
        super(location);
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.WHITE);
        setRadius(RADIUS);
    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        if (coordinate2D.getX() > RADIUS &&
                coordinate2D.getX() < getSceneWidth() - RADIUS &&
                coordinate2D.getY() > RADIUS &&
                coordinate2D.getY() < getSceneHeight() - RADIUS - 100) {
            setCursor(Cursor.NONE);

            setAnchorLocation(coordinate2D);
        } else if (getCursor().equals(Cursor.NONE)) {
            setCursor(Cursor.DEFAULT);
        }
    }
}
