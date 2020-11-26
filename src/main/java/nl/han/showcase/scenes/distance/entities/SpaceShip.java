package nl.han.showcase.scenes.distance.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

import java.util.Set;

/**
 * A {@link SpaceShip} is just a simple {@link DynamicCircleEntity} that can move around the
 * {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}. It implements the
 * {@link KeyListener} interface for listening to key strokes and
 * {@link SceneBorderTouchingWatcher} to be notified if it touches the border of the
 * {@link com.github.hanyaeger.api.engine.scenes.YaegerScene}. When that happens its speed
 * is set to 0.
 * <p>
 * The interface {@link Collider} is used to registers collisions with a {@link Rocket}.
 */
public class SpaceShip extends DynamicCircleEntity implements KeyListener, SceneBorderTouchingWatcher, Collider {

    private static final double SPACESHIP_SPEED = 5;

    public SpaceShip(Coordinate2D location) {
        super(location);
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.WHITE);
        setRadius(20);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(SPACESHIP_SPEED, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(SPACESHIP_SPEED, Direction.RIGHT);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(SPACESHIP_SPEED, Direction.UP);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(SPACESHIP_SPEED, Direction.DOWN);
        } else if (pressedKeys.isEmpty()) {
            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
    }
}
