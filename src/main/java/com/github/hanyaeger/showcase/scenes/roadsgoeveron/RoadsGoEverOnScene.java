package com.github.hanyaeger.showcase.scenes.roadsgoeveron;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.ShowCaseScene;
import com.github.hanyaeger.showcase.scenes.roadsgoeveron.entities.*;
import com.github.hanyaeger.showcase.scenes.roadsgoeveron.spawners.TextSpawner;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * To present text on the screen, Yaeger supports the {@link TextEntity} and its dynamic partner,
 * the {@link com.github.hanyaeger.api.entities.impl.DynamicTextEntity}. This
 * {@link com.github.hanyaeger.api.scenes.DynamicScene} displays different Use Cases regarding
 * these Entities.
 */
public class RoadsGoEverOnScene extends ShowCaseScene implements EntitySpawnerContainer {

    private static final String TEXT_STATIC_ENTITY = "I'm a TextEntity and remain static on the Scene";

    private EntitySpawner textSpawner;
    private PauseResumeButton pauseResumeButton;
    private RemoveRenewButton removeRenewButton;

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

        pauseResumeButton = new PauseResumeButton(new Coordinate2D(100, getHeight() - BOTTOM_MARGIN), this);
        addEntity(pauseResumeButton);

        removeRenewButton = new RemoveRenewButton(new Coordinate2D(270, getHeight() - BOTTOM_MARGIN), this);
        addEntity(removeRenewButton);
    }

    @Override
    public void setupEntitySpawners() {
        textSpawner = new TextSpawner(700, getWidth(), getHeight());
        addEntitySpawner(textSpawner);
    }

    public void pauseResumeSpawner() {
        if (textSpawner == null) {
            return;
        }

        if (textSpawner.isActive()) {
            textSpawner.pause();
            pauseResumeButton.setResumeTextText();
        } else {
            textSpawner.resume();
            pauseResumeButton.setPauseText();
        }
    }

    public void removeRenewSpawner() {
        if (textSpawner == null) {
            removeRenewButton.setRemoveText();
            textSpawner = new TextSpawner(700, getWidth(), getHeight());
            addEntitySpawner(textSpawner);
            pauseResumeButton.setPauseText();
        } else {
            textSpawner.remove();
            textSpawner = null;
            removeRenewButton.setRenewText();
        }
    }
}
