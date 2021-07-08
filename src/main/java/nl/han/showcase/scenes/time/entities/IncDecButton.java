package nl.han.showcase.scenes.time.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.shared.buttons.BorderButton;
import nl.han.showcase.scenes.time.spawners.ClockSpawner;

/**
 * An abstract superclass for both the {@link IncrementButton} and {@link DecrementButton}, since
 * both share almost exactly the same behaviour.
 * <p>
 * With this implementation, the {@link com.github.hanyaeger.api.userinput.MouseButtonPressedListener#onMouseButtonPressed(MouseButton, Coordinate2D)}
 * must be handled in the subclass. A nicer approach would be to pass the function-call as a parameter to
 * this constructor and then call it from the handler implemented in this superclass. But that would require the
 * use of a lambda, which we try to prevent in this code.
 */
public abstract class IncDecButton extends BorderButton {
    protected final ClockSpawner clockSpawner;

    public IncDecButton(final Coordinate2D initialLocation, final String text, final ClockSpawner clockSpawner) {
        super(initialLocation, text, 40);
        this.clockSpawner = clockSpawner;
    }
}
