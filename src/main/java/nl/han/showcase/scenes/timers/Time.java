package nl.han.showcase.scenes.timers;

import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.timers.timers.SceneMinuteTimer;

public class Time extends ShowCaseScene implements TimerContainer {

    public static final int COUNTDOWN_NUMBER = 5;
    private TextEntity displayNumberText;
    private int displayNumber;

    public Time(YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupTimers() {
        displayNumber = COUNTDOWN_NUMBER;
        addTimer(new SceneMinuteTimer(this));
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/timer.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        displayNumberText = new TextEntity(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 10), Integer.toString(displayNumber));
        displayNumberText.setFont(HanFont.createDefaultFont(100));
        displayNumberText.setFill(Color.WHITE);
        displayNumberText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(displayNumberText);
    }

    public void update() {
        if (displayNumber <= 0) {
            displayNumber = COUNTDOWN_NUMBER;
            showCase.setActiveScene(YaegerShowCase.SCENE_SELECTION);
        } else {
            displayNumberText.setText(Integer.toString(displayNumber--));
        }
    }
}
