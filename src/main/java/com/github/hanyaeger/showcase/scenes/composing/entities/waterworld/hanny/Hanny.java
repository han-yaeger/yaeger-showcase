package com.github.hanyaeger.showcase.scenes.composing.entities.waterworld.hanny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.showcase.YaegerShowCase;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

/**
 * Contrary to the Tutorial, Hanny is now created as a composition, through the use of a
 * {@link DynamicCompositeEntity}. This composition consists of two Entities: Hanny and a text that
 * displays her health.
 * <p>
 * Because the composition will act as a whole, this is the place where we implement {@link KeyListener} and
 * {@link Collided}.
 */
public class Hanny extends DynamicCompositeEntity implements KeyListener, Collided {

    private int health = 10;

    private HannySprite hannySprite;
    private TextEntity healthText;

    public Hanny(final Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        healthText = new TextEntity(new Coordinate2D(0, 0), String.valueOf(health));
        healthText.setFill(YaegerShowCase.HAN_RED);
        addEntity(healthText);

        hannySprite = new HannySprite(new Coordinate2D(0, 10));
        addEntity(hannySprite);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            hannySprite.setCurrentFrameIndex(0);
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            hannySprite.setCurrentFrameIndex(1);
            setMotion(3, Direction.RIGHT);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, Direction.UP);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, Direction.DOWN);
        } else if (pressedKeys.isEmpty()) {
            setSpeed(0);
        }
    }

    @Override
    public void onCollision(final List<Collider> collidingObject) {
        healthText.setText(String.valueOf(health--));
    }
}
