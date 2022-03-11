package com.github.hanyaeger.showcase.shared.explosion;

import com.github.hanyaeger.api.Coordinate2D;

/**
 * Using this interface, it is possible to let different scenes be able to add an explosion.
 */
public interface ExplosionAdder {
    void addExplosion(final Coordinate2D anchorLocation, final double speed, final double direction);
}
