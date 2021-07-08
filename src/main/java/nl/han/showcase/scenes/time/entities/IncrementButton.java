package nl.han.showcase.scenes.time.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.scenes.time.spawners.ClockSpawner;

public class IncrementButton extends IncDecButton {

    public IncrementButton(final Coordinate2D location, final ClockSpawner clockSpawner) {
        super(location, "+", clockSpawner);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        clockSpawner.increaseSpeed();
    }
}
