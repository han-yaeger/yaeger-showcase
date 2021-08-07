package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
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
    public void onCollision(final Collider collidingObject) {
        newtonianCircleComposite.onCollision(collidingObject);
    }
}
