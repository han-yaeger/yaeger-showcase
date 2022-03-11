package com.github.hanyaeger.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class BlueBallCircling extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

    public BlueBallCircling(final Coordinate2D location) {
        super("entities/ball-blue.png", location, new Size(30, 30));
        setMotion(8, Direction.RIGHT);

    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        if (border.equals(SceneBorder.RIGHT)) {
            setAnchorLocationX(-30);
        }
    }
}
