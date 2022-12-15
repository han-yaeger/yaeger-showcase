package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public abstract class WitchCollisionBox extends RectangleEntity implements Collided {

    protected WitchComposition parent;

    public WitchCollisionBox(final Coordinate2D initialLocation, final WitchComposition parent, Size size) {
        super(initialLocation, size);
        this.parent = parent;
        setFill(Color.TRANSPARENT);
    }
}
