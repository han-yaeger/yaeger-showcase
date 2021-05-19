package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

/**
 * A {@link SpaceShip} is just a simple {@link DynamicCircleEntity} that can move around the
 * {@link com.github.hanyaeger.api.scenes.DynamicScene}.
 * <p>
 * The interface {@link Collider} is used to registers collisions with a {@link Rocket}.
 */
public class SpaceShip extends DynamicCircleEntity implements MouseMovedListener, Collider {

    private static final double RADIUS = 20;

    public SpaceShip(final Coordinate2D location) {
        super(location);
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.WHITE);
        setRadius(RADIUS);
    }

    @Override
    public void onMouseMoved(final Coordinate2D coordinate2D) {
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
