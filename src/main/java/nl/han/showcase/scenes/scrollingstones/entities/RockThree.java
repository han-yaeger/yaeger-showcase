package nl.han.showcase.scenes.scrollingstones.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.han.showcase.shared.explosion.ExplosionAdder;

public class RockThree extends Rock {

    public RockThree(final Coordinate2D initialLocation, final double direction, final double speed, final ExplosionAdder explosionAdder) {
        super("entities/rock3.png", initialLocation, new Size(30, 30), 4, 5, explosionAdder);
        setAutoCycle(70);
        setMotion(speed, direction);
    }
}
