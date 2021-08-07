package nl.han.showcase.scenes.time;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.time.entities.*;
import nl.han.showcase.scenes.time.spawners.ClockSpawner;
import nl.han.showcase.scenes.time.timers.SceneMinuteTimer;

public class Time extends ShowCaseScene implements TimerContainer, EntitySpawnerContainer {

    public static final int COUNTDOWN_NUMBER_START_VALUE = 25;
    private TextEntity displayNumberText;
    private PauseResumeGWUButton pauseResumeGWUButton;
    private PauseResumeTimerButton pauseResumeTimerButton;
    private RemoveRenewButton removeRenewButton;

    private Timer sceneSecondsTimer;
    private int displayNumber = COUNTDOWN_NUMBER_START_VALUE;
    private SpawningSpeed spawningSpeedButton;
    private ClockSpawner clockSpawner;


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

        // Since we need a reference to the ClockSpawner for the spawningSpeedButton, we instantiate it before
        // the setupTimers() method. This way we can ensure the reference passed to the spawningSpeedButton is
        // not null.
        clockSpawner = new ClockSpawner(getWidth());

        displayNumberText = new TextEntity(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 22), Integer.toString(displayNumber));
        displayNumberText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        displayNumberText.setFill(Color.WHITE);
        displayNumberText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(displayNumberText);

        pauseResumeGWUButton = new PauseResumeGWUButton(new Coordinate2D(110, getHeight() - BOTTOM_MARGIN), this);
        addEntity(pauseResumeGWUButton);

        spawningSpeedButton = new SpawningSpeed(new Coordinate2D(260, getHeight() - BOTTOM_MARGIN), clockSpawner);
        addEntity(spawningSpeedButton);

        var spawningIntervalText = new SpawnerIntervalText(new Coordinate2D(getWidth() - BOTTOM_MARGIN, 8), clockSpawner);
        addEntity(spawningIntervalText);

        pauseResumeTimerButton = new PauseResumeTimerButton(new Coordinate2D(270, 520), this);
        addEntity(pauseResumeTimerButton);

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
        if (sceneSecondsTimer == null) {
            return;
        }

        if (sceneSecondsTimer.isActive()) {
            sceneSecondsTimer.pause();
            pauseResumeTimerButton.setResumeTextText();
        } else {
            sceneSecondsTimer.resume();
            pauseResumeTimerButton.setPauseText();
        }
    }

    public void removeRenewTimer() {
        if (sceneSecondsTimer == null) {
            removeRenewButton.setRemoveText();
            displayNumber = COUNTDOWN_NUMBER_START_VALUE;
            sceneSecondsTimer = new SceneMinuteTimer(this);
            addTimer(sceneSecondsTimer);
            pauseResumeTimerButton.setPauseText();
        } else {
            sceneSecondsTimer.remove();
            sceneSecondsTimer = null;
            removeRenewButton.setRenewText();
        }
    }

    public void pauseResumeGWU() {
        if (isActiveGWU()) {
            pause();
            pauseResumeGWUButton.setResumeTextText();
        } else {
            resume();
            pauseResumeGWUButton.setPauseText();
        }
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(clockSpawner);
    }
}
