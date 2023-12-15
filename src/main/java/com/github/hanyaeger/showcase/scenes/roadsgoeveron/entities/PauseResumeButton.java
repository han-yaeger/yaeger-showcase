package com.github.hanyaeger.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import com.github.hanyaeger.showcase.shared.buttons.BorderButton;
import com.github.hanyaeger.showcase.scenes.roadsgoeveron.RoadsGoEverOnScene;

public class PauseResumeButton extends BorderButton {

    public static final String PAUSE_TEXT = "Pause Spawner";
    public static final String RESUME_TEXT = "Resume Spawner";
    private final RoadsGoEverOnScene roadsGoEverOnScene;

    public PauseResumeButton(final Coordinate2D location, final RoadsGoEverOnScene roadsGoEverOnScene) {
        super(location, PAUSE_TEXT, 160);
        this.roadsGoEverOnScene = roadsGoEverOnScene;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        roadsGoEverOnScene.pauseResumeSpawner();
    }

    public void setPauseText() {
        setText(PAUSE_TEXT);
    }

    public void setResumeTextText() {
        setText(RESUME_TEXT);
    }
}
