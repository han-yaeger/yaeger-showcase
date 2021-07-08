package nl.han.showcase.scenes.time.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.shared.buttons.BorderButton;
import nl.han.showcase.scenes.time.Time;

public class PauseResumeGWUButton extends BorderButton {

    public static final String PAUSE_TEXT = "Pause GWU";
    public static final String RESUME_TEXT = "Resume GWU";
    private final Time time;

    public PauseResumeGWUButton(final Coordinate2D location, final Time time) {
        super(location, PAUSE_TEXT, 130);
        this.time = time;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        time.pauseResumeGWU();
    }

    public void setPauseText(){
        setText(PAUSE_TEXT);
    }

    public void setResumeTextText(){
        setText(RESUME_TEXT);
    }
}
