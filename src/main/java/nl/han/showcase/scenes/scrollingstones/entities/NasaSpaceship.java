package nl.han.showcase.scenes.scrollingstones.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.shared.explosion.ExplosionAdder;

import java.util.Set;

public class NasaSpaceship extends DynamicSpriteEntity implements KeyListener, Newtonian, ExplosionAdder, SceneBorderTouchingWatcher {

    private ExplosionAdder explosionAdder;

    public NasaSpaceship(final Coordinate2D initialLocation, final ExplosionAdder explosionAdder) {
        super("entities/spaceship.png", initialLocation);
        this.explosionAdder = explosionAdder;
        setViewOrder(10);
        setGravityConstant(0);
    }

    @Override
    public void onPressedKeysChange(final Set<KeyCode> pressedKeys) {
        var direction = getDirection();

        if (pressedKeys.contains(KeyCode.LEFT)) {
            direction += 4;
        }
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            direction -= 4;
        }

        if (pressedKeys.contains(KeyCode.SPACE)) {
            setSpeed(getSpeed() + 0.4);
        }

        setDirection(direction);
    }

    /**
     * We overwrite the setDirection to ensure the direction is always tied to the rotation of the spaceship.
     *
     * @param newDirection the new direction that the spaceship should travel to
     */
    @Override
    public void setDirection(double newDirection) {
        setRotate(newDirection);
        super.setDirection(newDirection);
    }

    @Override
    public void addExplosion(Coordinate2D anchorLocation, double speed, double direction) {
        explosionAdder.addExplosion(getAnchorLocation(), getSpeed(), getDirection());
        remove();
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        addExplosion(getAnchorLocation(), 0, 0);
    }
}
