package nl.han.showcase.scenes.time;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.text.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.time.entities.PauseResumeButton;
import nl.han.showcase.scenes.time.entities.RemoveRenewButton;
import nl.han.showcase.scenes.time.timers.SceneMinuteTimer;

public class Time extends ShowCaseScene implements TimerContainer {

    public static final int COUNTDOWN_NUMBER_START_VALUE = 25;
    private TextEntity displayNumberText;
    private PauseResumeButton pauseResumeButton;
    private RemoveRenewButton removeRenewButton;

    private Timer sceneSecondsTimer;
    private int displayNumber = COUNTDOWN_NUMBER_START_VALUE;

    public Time(YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupTimers() {
        sceneSecondsTimer = new SceneMinuteTimer(this);
        addTimer(sceneSecondsTimer);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/timer.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        displayNumberText = new TextEntity(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 22), Integer.toString(displayNumber));
        displayNumberText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        displayNumberText.setFill(Color.WHITE);
        displayNumberText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(displayNumberText);

        pauseResumeButton = new PauseResumeButton(new Coordinate2D(270, 520), this);
        addEntity(pauseResumeButton);

        removeRenewButton = new RemoveRenewButton(new Coordinate2D(430, 520), this);
        addEntity(removeRenewButton);

    }

    /**
     * A public {@code #update()} that is used by the {@link SceneMinuteTimer} to count down the number displayed.
     */
    public void update() {
        if (displayNumber <= 0) {
            displayNumber = COUNTDOWN_NUMBER_START_VALUE;
            showCase.setActiveScene(YaegerShowCase.SCENE_SELECTION);
        } else {
            displayNumberText.setText(Integer.toString(displayNumber--));
        }
    }

    public void pauseResumeTimer() {
        if (sceneSecondsTimer == null){
            return;
        }

        if (sceneSecondsTimer.isActive()) {
            sceneSecondsTimer.pause();
            pauseResumeButton.setResumeTextText();
        } else {
            sceneSecondsTimer.resume();
            pauseResumeButton.setPauseText();
        }
    }

    public void removeRenewTimer() {
        if (sceneSecondsTimer == null) {
            removeRenewButton.setRemoveText();
            displayNumber = COUNTDOWN_NUMBER_START_VALUE;
            sceneSecondsTimer = new SceneMinuteTimer(this);
            addTimer(sceneSecondsTimer);
        } else {
            sceneSecondsTimer.remove();
            sceneSecondsTimer = null;
            removeRenewButton.setRenewText();
        }
    }
}
