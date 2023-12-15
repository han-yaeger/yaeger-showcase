package com.github.hanyaeger.showcase.scenes.distance.entities.dragndrop;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.userinput.MouseDraggedListener;
import com.github.hanyaeger.showcase.shared.textfield.TextFieldBackground;
import javafx.scene.paint.Color;

public class Draggable extends TextFieldBackground implements MouseDraggedListener {

    private Coordinate2D initialPosition;
    private double definedHue;
    private double definedSaturation;

    public Draggable(final Coordinate2D initialPosition, final Color color, final double definedHue, final double definedSaturation) {
        super(initialPosition, new Size(20, 20), color);

        this.initialPosition = initialPosition;
        this.definedHue = definedHue;
        this.definedSaturation = definedSaturation;
    }

    @Override
    public void onDragged(final Coordinate2D coordinate2D) {
        setAnchorLocation(coordinate2D);
    }

    @Override
    public void onDropped(final Coordinate2D coordinate2D) {
        setAnchorLocation(initialPosition);
    }

    public double getDefinedHue() {
        return definedHue;
    }

    public double getDefinedSaturation() {
        return definedSaturation;
    }
}
