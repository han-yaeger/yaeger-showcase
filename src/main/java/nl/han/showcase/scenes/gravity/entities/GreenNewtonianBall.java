package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.input.KeyCode;
import nl.han.showcase.scenes.gravity.Gravity;

import java.util.Set;

public class GreenNewtonianBall extends DynamicSpriteEntity implements Newtonian, Collided, KeyListener, SceneBorderCrossingWatcher {

    private static final double SPEED = 3;
    private Gravity gravity;

    public GreenNewtonianBall(final Coordinate2D location, final Gravity gravity) {
        super("entities/ball-green.png", location, new Size(20, 20), 0);
        this.gravity = gravity;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof FallCollider) {
            setGravitationalPull(true);
        } else {
            setGravitationalPull(false);
            setSpeed(0);
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (isGravitationalPull()) {
            return;
        }

        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(SPEED, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(SPEED, Direction.RIGHT);
        } else {
            setSpeed(0);
        }

        if (pressedKeys.contains(KeyCode.SPACE)) {
            setGravitationalPull(true);
            addToMotion(2 * SPEED, Direction.UP);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (SceneBorder.TOP.equals(border)) {
            return;
        }

        gravity.spawnNewBall();
        remove();
    }
}
