package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SpawnedTextEntity extends DynamicTextEntity implements UpdateExposer, SceneBorderCrossingWatcher {

    public SpawnedTextEntity(final Coordinate2D initialPosition) {
        super(initialPosition);
        setText("Spawned");
        setAnchorPoint(AnchorPoint.TOP_RIGHT);
        setFill(Color.AQUA);
        setMotion(1, Direction.UP);
        setFont(Font.font("Arial", FontWeight.BOLD, 12));
    }

    /**
     * The {@link UpdateExposer#explicitUpdate(long)} is used to give the entity a fade-out effect
     *
     * @param timestamp current timestamp
     */
    @Override
    public void explicitUpdate(long timestamp) {
        setOpacity(getOpacity() - 0.002);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        remove();
    }
}
