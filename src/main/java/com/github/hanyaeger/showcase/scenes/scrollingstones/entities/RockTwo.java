package com.github.hanyaeger.showcase.scenes.scrollingstones.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.showcase.shared.explosion.ExplosionAdder;

public class RockTwo extends Rock {

    public RockTwo(final Coordinate2D initialLocation, final double direction, final double speed, final ExplosionAdder explosionAdder) {
        super("entities/rock2.png", initialLocation, new Size(40, 40), 3, 7, explosionAdder);
        setAutoCycle(80);
        setMotion(speed, direction);
    }
}
