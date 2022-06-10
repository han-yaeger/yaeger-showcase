package com.github.hanyaeger.showcase.scenes.zombie.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Zombie extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided {

    private static final int AUTOCYCLE_SPEED = 100;
    private static final int WALKING_SPEED_RIGHT = 2;
    private static final int WALKING_SPEED_LEFT = 2;

    public Zombie(final Coordinate2D initialLocation) {
        super("entities/zombie-spritemap.png", initialLocation, 2, 12);
    }

    @Override
    public void onPressedKeysChange(final Set<KeyCode> pressedKeys) {
        if (pressedKeys.isEmpty() || pressedKeys.contains(KeyCode.RIGHT) && pressedKeys.contains(KeyCode.LEFT)) {
            setSpeed(0);
            setAutoCycle(0);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setAutoCycleRow(0);
            setMotion(WALKING_SPEED_RIGHT, Direction.RIGHT);
            setAutoCycle(AUTOCYCLE_SPEED);
        } else if (pressedKeys.contains(KeyCode.LEFT)) {
            setAutoCycleRow(1);
            setMotion(WALKING_SPEED_LEFT, Direction.LEFT);
            setAutoCycle(AUTOCYCLE_SPEED);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
        if (SceneBorder.LEFT.equals(border)) {
            setAnchorLocationX(0);
        } else if (SceneBorder.RIGHT.equals(border)) {
            setAnchorLocationX(getSceneWidth() - getWidth());
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        setSpeed(0);
    }
}
