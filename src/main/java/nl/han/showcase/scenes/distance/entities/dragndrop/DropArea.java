package nl.han.showcase.scenes.distance.entities.dragndrop;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.paint.Color;
import nl.han.showcase.scenes.distance.RocketSpawner;
import nl.han.showcase.scenes.distance.entities.textfield.TextFieldBackground;

public class DropArea extends TextFieldBackground implements MouseDragEnterListener, MouseDragExitedListener, MouseDropListener {

    private RocketSpawner rocketSpawner;

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
        if (source instanceof Draggable draggable){
            rocketSpawner.setHue(draggable.getDefinedHue());
            rocketSpawner.setSaturation(draggable.getDefinedSaturation());
        }
    }
}
