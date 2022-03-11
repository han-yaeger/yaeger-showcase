package com.github.hanyaeger.showcase.shared;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class HanLogoHeader extends SpriteEntity {

    /**
     * Since the logo header will be positioned in the top left corner, there is no need for a constructor
     * that accepts parameters.
     */
    public HanLogoHeader() {
        super("backgrounds/han-logo.png", new Coordinate2D(0, 0));
        setViewOrder(100);
    }
}
