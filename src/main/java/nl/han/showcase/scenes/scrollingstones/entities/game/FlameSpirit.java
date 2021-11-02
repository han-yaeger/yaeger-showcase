package nl.han.showcase.scenes.scrollingstones.entities.game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class FlameSpirit extends DynamicSpriteEntity implements Collided, KeyListener, SceneBorderTouchingWatcher, Newtonian {

    private static final double SPEED_INITIAL = 1;
    private static final double SPEED_MAX = 4;

    public FlameSpirit(final Coordinate2D initialLocation) {
        super("entities/flame-spirit.png", initialLocation, 6, 10);
        setGravityConstant(0.001);
        setAutoCycle(50);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        System.out.println("Collision");
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.isEmpty()) {
            return;
        }

        var invertHorizontalComponent = false;

        var newMotion = new Coordinate2D();

        if (pressedKeys.contains(KeyCode.DOWN)) {
            newMotion = newMotion.add(new Coordinate2D(0, 1));
        }
        if (pressedKeys.contains(KeyCode.UP)) {
            newMotion = newMotion.add(new Coordinate2D(0, -1));
        }
        if (pressedKeys.contains(KeyCode.LEFT)) {
            newMotion = newMotion.add(new Coordinate2D(-1, 0));
            invertHorizontalComponent = true;
        }
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            newMotion = newMotion.add(new Coordinate2D(1, 0));
        }

        var direction = new Coordinate2D(0, 1).angle(newMotion);

        if (invertHorizontalComponent) {
            direction = 360 - direction;
        }

        setMotion(1, direction);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        // To ensure the Entity cannot leave the scene, we set the correct
        // anchorLocation x or y if it touches the scene border.
        switch (border) {
            case LEFT -> setAnchorLocationX(0);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth());
            case TOP -> setAnchorLocationY(0);
            case BOTTOM -> setAnchorLocationY(getSceneHeight() - getHeight());
        }
    }
}
