package nl.han.showcase.scenes.composing.entities.waterworld.hanny;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import javafx.scene.input.KeyCode;
import nl.han.showcase.YaegerShowCase;

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
            setMotion(3, Direction.LEFT.getValue());
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            hannySprite.setCurrentFrameIndex(1);
            setMotion(3, Direction.RIGHT.getValue());
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, Direction.UP.getValue());
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, Direction.DOWN.getValue());
        } else if (pressedKeys.isEmpty()) {
            setSpeed(0);
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        healthText.setText(String.valueOf(health--));
    }
}
