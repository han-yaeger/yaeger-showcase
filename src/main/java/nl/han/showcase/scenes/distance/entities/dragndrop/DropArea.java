package nl.han.showcase.scenes.distance.entities.dragndrop;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.paint.Color;
import nl.han.showcase.scenes.distance.entities.textfield.TextFieldBackground;

public class DropArea extends TextFieldBackground implements MouseDragEnterListener, MouseDragExitedListener, MouseDropListener {

    public DropArea(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);
    }

    @Override
    public void onDragEntered(final Coordinate2D coordinate2D, final MouseDraggedListener source) {
        System.out.println("Entering: " + source);
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
        System.out.println("Dropped");
    }
}
