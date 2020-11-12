package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.engine.entities.entity.CompositeEntity;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class Board extends RectangleEntity implements MouseButtonPressedListener {

    private final CompositeEntity composingParent;

    public Board(final Coordinate2D initialPosition, final CompositeEntity composingParent) {
        super(initialPosition);
        this.composingParent = composingParent;
        setWidth(6 * Circle.RADIUS);
        setHeight(6 * Circle.RADIUS);
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setFill(Color.BLACK);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        composingParent.remove();
    }
}
