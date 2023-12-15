package com.github.hanyaeger.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

/**
 * This {@link com.github.hanyaeger.api.entities.impl.TextEntity} demonstrates to features. By implementing
 * the interface {@link SceneBorderCrossingWatcher} it is notified whenever its crosses the border of
 * the scene. In such case it changes its color and it changes it direction by 180 degrees.
 * <p>
 * Secondly it is uses a {@link CustomFont}, which is based on a font file.
 */
public class SceneBorderCrossingDynamicTextEntity extends DynamicTextEntity implements SceneBorderCrossingWatcher {

    public static final String TEXT = "SceneBorderCrossing";

    public SceneBorderCrossingDynamicTextEntity(final Coordinate2D position) {
        super(position, TEXT);
        setFill(Color.TURQUOISE);
        setFont(new CustomFont("fonts/pixelfont.ttf", 35));
        setMotion(4, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setFill(Color.THISTLE);
        } else {
            setFill(Color.TURQUOISE);
        }

        changeDirection(180);
    }
}
