package nl.han.showcase.scenes.timers.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.buttons.BorderButton;
import nl.han.showcase.scenes.timers.Time;

public class PauseResumeButton extends BorderButton {

    public static final String PAUSE_TEXT = "Pause timer";
    public static final String RESUME_TEXT = "Resume timer";
    private final Time time;

    public PauseResumeButton(final Coordinate2D location, final Time time) {
        super(location, PAUSE_TEXT, 150);
        this.time = time;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        time.pauseResumeTimer();
    }

    public void setPauseText(){
        setText(PAUSE_TEXT);
    }

    public void setResumeTextText(){
        setText(RESUME_TEXT);
    }
}
