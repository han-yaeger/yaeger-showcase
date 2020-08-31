package nl.han.showcase.scenes.dynamicscenewithtimer;

import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.dynamicscenewithtimer.timers.SceneMinuteTimer;

public class DynamicSceneWithTimer extends ShowCaseScene implements TimerContainer {

    public static final int COUNTDOWN_NUMBER = 5;
    private TextEntity displayNumberText;
    private int displayNumber;

    public DynamicSceneWithTimer(YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupTimers() {
        displayNumber = COUNTDOWN_NUMBER;
        addTimer(new SceneMinuteTimer(this));
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/milky-way.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var explanationText = new TextEntity(new Coordinate2D(getWidth() / 2, 150), "This scene will automatically switch back to the selection scene in: ");
        explanationText.setFont(Font.font("palatino", FontWeight.BOLD, 30));
        explanationText.setFill(Color.YELLOW);
        explanationText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(explanationText);

        displayNumberText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), Integer.toString(displayNumber));
        displayNumberText.setFont(Font.font("palatino", FontWeight.BOLD, 300));
        displayNumberText.setFill(Color.YELLOW);
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
