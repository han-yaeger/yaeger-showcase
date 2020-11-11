package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class Circle extends CircleEntity implements MouseButtonPressedListener {

    public Circle(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(20);
        setFill(Color.TRANSPARENT);
        setStrokeColor(Color.WHITE);
        setStrokeWidth(0.2);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        remove();
    }
}
