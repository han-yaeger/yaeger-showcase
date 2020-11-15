package nl.han.showcase.scenes.composing.entities.car;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import javafx.scene.paint.Color;
import nl.han.showcase.scenes.composing.entities.car.wheel.Wheel;

/**
 * A composition of a car. Notice how the wheels themselves are also compositions and rotate.
 * The car itself is a {@link SceneBorderTouchingWatcher}, so the car can automatically move from left to right and
 * vice versa.
 */
public class Car extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {

    public final static Color BODY_COLOR = Color.rgb(109, 0, 65);

    private Wheel rightWheel;
    private Wheel leftWheel;

    public Car(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(4, Direction.RIGHT);
    }

    @Override
    protected void setupEntities() {
        var body = new Body(new Coordinate2D(0, 20));
        addEntity(body);

        var top = new Top(new Coordinate2D(30, 0));
        addEntity(top);

        leftWheel = new Wheel(new Coordinate2D(10, 30));
        leftWheel.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(leftWheel);

        rightWheel = new Wheel(new Coordinate2D(body.getWidth() - 10, 30));
        rightWheel.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(rightWheel);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirection(180);
        leftWheel.setRotationSpeed(-1 * leftWheel.getRotationSpeed());
        rightWheel.setRotationSpeed(-1 * rightWheel.getRotationSpeed());
    }
}
