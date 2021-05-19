package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.scenes.composing.Composing;

import java.util.Set;

public class NewtonianCircleComposite extends DynamicCompositeEntity implements Newtonian, KeyListener, SceneBorderCrossingWatcher {

    private final Composing composing;

    public NewtonianCircleComposite(final Coordinate2D initialLocation, final Composing composing) {
        super(initialLocation);
        this.composing = composing;
    }

    @Override
    protected void setupEntities() {
        var outerCircle = new OuterCircle(new Coordinate2D(0, 0));
        addEntity(outerCircle);

        var innerCircle = new InnerCircle(new Coordinate2D(OuterCircle.RADIUS, OuterCircle.RADIUS), this);
        innerCircle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(innerCircle);
    }

    public void onCollision(final Collider collidingObject) {
        // The vertical (gravitational) component should be set to 0
        nullifySpeedInDirection(Direction.DOWN);
        // Place the Entity on the correct vertical location
        setAnchorLocationY(collidingObject.getBoundingBox().getMinY() - OuterCircle.RADIUS - InnerCircle.RADIUS);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.Z)) {
            maximizeMotionInDirection(Direction.LEFT, 1);
        } else if (pressedKeys.contains(KeyCode.X)) {
            maximizeMotionInDirection(Direction.RIGHT, 1);
        }
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        composing.placeNewtonianCircle();
        remove();
    }
}
