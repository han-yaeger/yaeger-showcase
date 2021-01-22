package nl.han.showcase.scenes.composing.entities.newtoniancircle;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Newtonian;

public class NewtonianCircleComposite extends DynamicCompositeEntity implements Newtonian {

    public NewtonianCircleComposite(final Coordinate2D initialLocation) {
        super(initialLocation);
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
}
