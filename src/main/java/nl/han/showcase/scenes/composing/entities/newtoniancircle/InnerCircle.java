package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class InnerCircle extends CircleEntity implements Collided {

    public static final double RADIUS = 4;
    private final NewtonianCircleComposite newtonianCircleComposite;

    public InnerCircle(final Coordinate2D initialPosition, final NewtonianCircleComposite newtonianCircleComposite) {
        super(initialPosition);
        this.newtonianCircleComposite = newtonianCircleComposite;

        setRadius(RADIUS);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        newtonianCircleComposite.onCollision(collidingObject);
    }
}
