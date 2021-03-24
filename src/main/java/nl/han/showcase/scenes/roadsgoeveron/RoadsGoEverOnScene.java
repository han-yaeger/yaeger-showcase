package nl.han.showcase.scenes.roadsgoeveron;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.roadsgoeveron.entities.*;

/**
 * To present text on the screen, Yaeger supports the {@link TextEntity} and its dynamic partner,
 * the {@link com.github.hanyaeger.api.engine.entities.entity.shape.text.DynamicTextEntity}. This
 * {@link com.github.hanyaeger.api.engine.scenes.YaegerScene} displays different Use Cases regarding
 * these Entities.
 */
public class RoadsGoEverOnScene extends ShowCaseScene {

    private static final String TEXT_STATIC_ENTITY = "I'm a TextEntity and remain static on the Scene";

    public RoadsGoEverOnScene(YaegerShowCase showCase) {
        super(showCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/roads.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var staticTextEntity = new TextEntity(new Coordinate2D(getWidth() / 2, 100), TEXT_STATIC_ENTITY);
        staticTextEntity.setFill(YaegerShowCase.HAN_RED);
        staticTextEntity.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        staticTextEntity.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        addEntity(staticTextEntity);

        var borderTouching = new SceneBorderTouchingDynamicTextEntity(new Coordinate2D(getWidth() / 2, 150));
        borderTouching.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(borderTouching);

        var borderCrossing = new SceneBorderCrossingDynamicTextEntity(new Coordinate2D(getWidth() / 2, 200));
        borderCrossing.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(borderCrossing);

        var timed = new TimedDynamicTextEntity(new Coordinate2D(100, 250));
        addEntity(timed);

        var spinning = new SpinningTextEntity(new Coordinate2D(100, 350));
        addEntity(spinning);

        var rolling = new RollingTextEntity(new Coordinate2D(100, 450));
        addEntity(rolling);
    }
}
