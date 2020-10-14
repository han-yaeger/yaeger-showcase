package nl.han.showcase.scenes.composing.entities.aircraft;

import com.github.hanyaeger.api.engine.entities.entity.CompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;

public class CompositeAircraft extends CompositeEntity {

    public CompositeAircraft(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var aircraftBody = new AircraftBody(new Coordinate2D(50, 0));
        addEntity(aircraftBody);

        var aircraftWing = new AircraftWings(new Coordinate2D(0, 50));
        addEntity(aircraftWing);
    }
}
