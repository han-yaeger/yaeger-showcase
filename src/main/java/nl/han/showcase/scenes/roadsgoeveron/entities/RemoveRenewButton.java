package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.showcase.buttons.BorderButton;
import nl.han.showcase.scenes.roadsgoeveron.RoadsGoEverOnScene;
import nl.han.showcase.scenes.time.Time;

public class RemoveRenewButton extends BorderButton {

    public static final String REMOVE_TEXT = "Remove Spawner";
    public static final String RENEW_TEXT = "Renew Spawner";
    private final RoadsGoEverOnScene time;

    public RemoveRenewButton(final Coordinate2D location, final RoadsGoEverOnScene roadsGoEverOnScene) {
        super(location, REMOVE_TEXT, 150);
        this.time = roadsGoEverOnScene;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        time.removeRenewSpawner();
    }

    public void setRemoveText() {
        setText(REMOVE_TEXT);
    }

    public void setRenewText() {
        setText(RENEW_TEXT);
    }
}
