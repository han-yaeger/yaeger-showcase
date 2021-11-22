package nl.han.showcase.scenes.scrollingstones.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.han.showcase.shared.explosion.ExplosionAdder;

public class RockOne extends Rock {

    public RockOne(final Coordinate2D initialLocation, final double direction, final double speed, final ExplosionAdder explosionAdder) {
        super("entities/rock1.png", initialLocation, new Size(50, 50), 4, 5, explosionAdder);
        setAutoCycle(60);
        setMotion(speed, direction);
    }
}
