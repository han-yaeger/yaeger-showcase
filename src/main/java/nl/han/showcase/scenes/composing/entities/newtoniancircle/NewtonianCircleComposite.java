package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
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
        setAnchorLocationY(collidingObject.getBoundingBox().getMinY() - OuterCircle.RADIUS - InnerCircle.RADIUS);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.Z)) {
            setMotion(1, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.X)) {
            setMotion(1, Direction.RIGHT);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        composing.placeNewtonianCircle();
        remove();
    }
}
