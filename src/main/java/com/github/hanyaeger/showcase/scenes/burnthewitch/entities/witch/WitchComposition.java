package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.showcase.scenes.burnthewitch.BurnTheWitchScene;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.Floor;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.Wall;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.WitchCollidingBox;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Because we want the Witch to move freely around the Scene, we'll need collision detection with a
 * bounding box that is smaller that a single sprite of the Witch.
 */
public class WitchComposition extends DynamicCompositeEntity implements KeyListener, Newtonian {

    private static final int WALKING_SPEED = 2;
    public static final KeyCode ATTACK = KeyCode.Z;
    public static final KeyCode JUMP = KeyCode.SPACE;

    private Set<KeyCode> latestPressedKeys = new HashSet<>();

    /**
     * We store the direction of the witch, so we can easily figure out if we need to show the left- or right-orientated
     * animation. We could use the {@link #getDirection()} method from {@link DynamicSpriteEntity}, but because we also implement the
     * interface {@link Newtonian}, the direction of the witch will contain a downward component (gravity). Storing our own
     * variable is therefor a easier approach.
     */
    private double direction;

    /**
     * To ensure that the Witch can only jump while she is on the ground, we use a boolean to store that fact. Whenever
     * its value is {@code true}, the Witch is on a ground surface. As soon as she jumps, the value is set to
     * {@code false}, which prevents her from making another jump. Only on collision with a {@link WitchCollidingBox} we reset the
     * value to {@code true}.
     */
    private boolean touchdown = true;

    /**
     * To differentiate between when the Witch is moving or not, we keep that state in this boolean.
     */
    private boolean isMoving = false;
    private BurnTheWitchScene zombieScene;
    private Witch witch;
    private static final double DELTA_X = 15;
    private static final Coordinate2D RIGHT_GROUND_ANCHOR_LOCATION = new Coordinate2D(25, 15);
    private static final Coordinate2D RIGHT_WALL_ANCHOR_LOCATION = new Coordinate2D(20, 33);
    private static final Coordinate2D LEFT_GROUND_ANCHOR_LOCATION = new Coordinate2D(40, 15);
    private static final Coordinate2D LEFT_WALL_ANCHOR_LOCATION = new Coordinate2D(35, 33);

    private WitchFloorCollisionBox verticalCollisionBox;
    private WitchWallCollisionBox horizontalCollisionBox;

    public WitchComposition(final Coordinate2D initialLocation, final BurnTheWitchScene zombieScene) {
        super(initialLocation);

        this.zombieScene = zombieScene;

        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        direction = Direction.RIGHT.getValue();
    }

    @Override
    protected void setupEntities() {
        witch = new Witch(new Coordinate2D(0, 0), zombieScene, this);
        addEntity(witch);

        verticalCollisionBox = new WitchFloorCollisionBox(RIGHT_GROUND_ANCHOR_LOCATION, this);
        addEntity(verticalCollisionBox);

        horizontalCollisionBox = new WitchWallCollisionBox(RIGHT_WALL_ANCHOR_LOCATION, this);
        addEntity(horizontalCollisionBox);
    }

    private void setCollisionBoxesOnRightMovement() {
        verticalCollisionBox.setAnchorLocation(RIGHT_GROUND_ANCHOR_LOCATION);
        horizontalCollisionBox.setAnchorLocation(RIGHT_WALL_ANCHOR_LOCATION);
    }

    private void setCollisionBoxesOnLeftMovement() {
        verticalCollisionBox.setAnchorLocation(LEFT_GROUND_ANCHOR_LOCATION);
        horizontalCollisionBox.setAnchorLocation(LEFT_WALL_ANCHOR_LOCATION);
    }

    @Override
    public void onPressedKeysChange(final Set<KeyCode> pressedKeys) {
        latestPressedKeys = pressedKeys;

        if (pressedKeys.contains(ATTACK)) {
            if (touchdown) {
                setSpeed(0);
                if (direction == Direction.LEFT.getValue()) {
                    setCollisionBoxesOnLeftMovement();
                    witch.attackLeft();
                } else {
                    setCollisionBoxesOnRightMovement();
                    witch.attackRight();
                }
            } else {
                if (direction == Direction.LEFT.getValue()) {
                    setCollisionBoxesOnLeftMovement();
                    witch.attackJumpLeft();
                } else {
                    setCollisionBoxesOnRightMovement();
                    witch.attackJumpRight();
                }
            }
        } else if (touchdown && pressedKeys.isEmpty()) {
            isMoving = false;
            setSpeed(0);
            if (direction == Direction.LEFT.getValue()) {
                setCollisionBoxesOnLeftMovement();
                witch.idleLeft();
            } else {
                setCollisionBoxesOnRightMovement();
                witch.idleRight();
            }
        } else if (touchdown && pressedKeys.contains(JUMP)) {
            addToMotion(7, Direction.UP);
            touchdown = false;
            if (pressedKeys.contains(KeyCode.RIGHT)) {
                setCollisionBoxesOnRightMovement();
                witch.jumpRight();
            } else if (pressedKeys.contains(KeyCode.LEFT)) {
                setCollisionBoxesOnLeftMovement();
                witch.jumpLeft();
            } else {
                isMoving = false;
            }
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            // If the Witch needs to change direction, compensate for the image not being in the center of the sprite.
            if (direction == Direction.LEFT.getValue()) {
                setAnchorLocationX(getAnchorLocation().getX() + DELTA_X);
            }
            // Set the direction
            direction = Direction.RIGHT.getValue();
            // Ensure the collision box is set to cover de Witch
            setCollisionBoxesOnRightMovement();
            if (touchdown) {
                maximizeMotionInDirection(direction, WALKING_SPEED);
                witch.runRight();
            } else {
                witch.idleRight();
            }
        } else if (pressedKeys.contains(KeyCode.LEFT)) {
            // If the Witch needs to change direction, compensate for the image not being in the center of the sprite.
            if (direction == Direction.RIGHT.getValue()) {
                setAnchorLocationX(getAnchorLocation().getX() - DELTA_X);
            }
            // Set the direction
            direction = Direction.LEFT.getValue();
            // Ensure the collision box is set to cover de Witch
            setCollisionBoxesOnLeftMovement();
            if (touchdown) {
                maximizeMotionInDirection(direction, WALKING_SPEED);
                witch.runLeft();
            } else {
                witch.idleLeft();
            }
        }
    }

    /**
     * We overwrite the method from the superclass, because we only need to know if the direction is left or right. And
     * since the {@link MagicSpellCallback} needs acces to the direction of the {@code Witch}, we supply this method just
     * for that.
     *
     * @return a double of either {@link Direction#RIGHT} or {@link Direction#LEFT}
     */
    @Override
    public double getDirection() {
        return direction;
    }

    public void handleCollision(final Floor ground) {
        setAnchorLocationY(ground.getBoundingBox().getMinY() + 1);
        nullifySpeedInDirection(Direction.DOWN);
        touchdown = true;

        // Since the KeyListeners event handler is only called on a KeyPressed change event,
        // we use the latestPressedKeys to manually call it and ensure the Witch will behave
        // accordingly.
        onPressedKeysChange(latestPressedKeys);
    }

    public void handleCollision(final Wall wall) {
        setAnchorLocationX(wall.getBoundingBox().getMinX() - 50);
        nullifySpeedInDirection(Direction.RIGHT);
    }

    void die() {
        remove();
    }
}
