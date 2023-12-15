package com.github.hanyaeger.showcase.scenes.distance.entities.dragndrop;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.*;
import com.github.hanyaeger.showcase.scenes.distance.entities.energyball.EnergyBall;
import com.github.hanyaeger.showcase.shared.textfield.TextFieldBackground;
import javafx.scene.paint.Color;
import com.github.hanyaeger.showcase.scenes.distance.RocketSpawner;

/**
 * The {@code DropArea} changes its color, based on the {@link Draggable} that is being dragged over it. For this it
 * implements both the {@link MouseDragEnterListener} and {@link MouseDragExitedListener}.  Whenever notification from
 * the {@link MouseDragEnterListener} is received (through the event handler
 * {@link MouseDragEnterListener#onDragEntered(Coordinate2D, MouseDraggedListener)}), it casts the
 * {@link MouseDraggedListener} to a {@link RectangleEntity}, so it can call {@link RectangleEntity#getFill()}. This
 * {@link Color} is then used to set the fill of the {@code DropArea}.
 * <p>
 * To receive notification when a {@link Draggable} has been dropped, it implements the interface {@link MouseDropListener}.
 * When {@link MouseDropListener#onDrop(Coordinate2D, MouseDraggedListener)} is called it changes the hue and satuarion of the
 * {@link EnergyBall} by calling {@link RocketSpawner#setHue(double)} and
 * {@link RocketSpawner#setSaturation(double)}.
 */
public class DropArea extends TextFieldBackground implements MouseDragEnterListener, MouseDragExitedListener, MouseDropListener {

    private final RocketSpawner rocketSpawner;

    public DropArea(final Coordinate2D initialPosition, final Size size, RocketSpawner rocketSpawner) {
        super(initialPosition, size);
        this.rocketSpawner = rocketSpawner;
    }

    @Override
    public void onDragEntered(final Coordinate2D coordinate2D, final MouseDraggedListener source) {
        if (source instanceof RectangleEntity rectangle) {
            setFill(rectangle.getFill());
        }
    }

    @Override
    public void onDragExited(final Coordinate2D coordinate2D, final MouseDraggedListener source) {
        setFill(Color.BLACK);
    }

    @Override
    public void onDrop(final Coordinate2D coordinate2D, final MouseDraggedListener source) {
        if (source instanceof Draggable draggable) {
            rocketSpawner.setHue(draggable.getDefinedHue());
            rocketSpawner.setSaturation(draggable.getDefinedSaturation());
        }
    }
}
