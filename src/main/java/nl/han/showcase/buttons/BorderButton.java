package nl.han.showcase.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;

/**
 * Since all buttons need a same layout, we create an abstract {@link CompositeEntity} that contains both a
 * {@link com.github.hanyaeger.api.entities.impl.text.TextEntity} and a
 * {@link com.github.hanyaeger.api.entities.impl.rectangle.RectangleEntity}.
 */
public abstract class BorderButton extends CompositeEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private ButtonText buttonText;
    private final String text;
    private final double width;

    public BorderButton(final Coordinate2D initialLocation, final String text, final double width) {
        super(initialLocation);
        this.text = text;
        this.width = width;
    }

    @Override
    protected void setupEntities() {
        ButtonBackground buttonBackground = new ButtonBackground(new Coordinate2D(0, 0), new Size(width, 36));
        addEntity(buttonBackground);

        buttonText = new ButtonText(new Coordinate2D(9, 2), text);
        addEntity(buttonText);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        buttonText.onMouseEntered();
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        buttonText.onMouseExited();
    }
}
