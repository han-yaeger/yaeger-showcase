package nl.han.showcase.scenes.textentities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.textentities.entities.SceneBorderCrossingDynamicTextEntity;
import nl.han.showcase.scenes.textentities.entities.SceneBorderTouchingDynamicTextEntity;
import nl.han.showcase.scenes.textentities.entities.TimedDynamicTextEntity;

public class TextEntitiesScene extends ShowCaseScene {

    public TextEntitiesScene(YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/milky-way.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var staticTextEntity = new TextEntity(new Coordinate2D(getWidth() / 2, 30), "I'm a TextEntity and remain static on the Scene");
        staticTextEntity.setFill(Color.ORANGE);
        staticTextEntity.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        staticTextEntity.setFont(Font.font("American Typewriter", FontWeight.BOLD, 30));
        addEntity(staticTextEntity);

        var borderTouchingDynamicTextEntity = new SceneBorderTouchingDynamicTextEntity(new Coordinate2D(getWidth() / 2, 60));
        borderTouchingDynamicTextEntity.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(borderTouchingDynamicTextEntity);

        var borderCrossingDynamicTextEntity = new SceneBorderCrossingDynamicTextEntity(new Coordinate2D(getWidth() / 2, 90));
        borderCrossingDynamicTextEntity.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(borderCrossingDynamicTextEntity);

        var timedDynamicTextEntity = new TimedDynamicTextEntity(new Coordinate2D(400, 120));
        addEntity(timedDynamicTextEntity);
    }
}
