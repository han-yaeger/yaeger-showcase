package nl.han.showcase.scenes.composing.entities.wheel;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.DynamicCompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;

public class Wheel extends DynamicCompositeEntity {

    public Wheel(Coordinate2D initialLocation) {
        super(initialLocation);
        setRotationSpeed(4);
        setMotion(1, Direction.RIGHT.getValue());
    }

    @Override
    protected void setupEntities() {
        var spoke1 = new Spoke(new Coordinate2D(30, 30));
        addEntity(spoke1);
        var spoke2 = new Spoke(new Coordinate2D(30, 30));
        spoke2.setRotate(45);
        addEntity(spoke2);
        var spoke3 = new Spoke(new Coordinate2D(30, 30));
        spoke3.setRotate(90);
        addEntity(spoke3);
        var spoke4 = new Spoke(new Coordinate2D(30, 30));
        spoke4.setRotate(135);
        addEntity(spoke4);
        var tire = new Tire(new Coordinate2D(30, 30));
        addEntity(tire);
    }
}
