package nl.han.showcase.scenes.composing.entities.blackboard;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

public class Circle extends CircleEntity implements MouseButtonPressedListener {

    public static final double RADIUS = 30;

    public Circle(Coordinate2D initialPosition) {
        super(initialPosition);
        setRadius(RADIUS);
        setFill(Color.TRANSPARENT);
        setStrokeColor(YaegerShowCase.HAN_RED);
        setStrokeWidth(1);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        remove();
    }
}
