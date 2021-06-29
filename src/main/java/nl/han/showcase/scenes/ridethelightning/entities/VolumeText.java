package nl.han.showcase.scenes.ridethelightning.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.text.DynamicTextEntity;
import nl.han.showcase.scenes.distance.entities.textfield.DynamicShowCaseTextField;
import nl.han.showcase.scenes.ridethelightning.RideTheLightningScene;

/**
 * A simple {@link DynamicTextEntity} that implements the interface {@link UpdateExposer}
 * to update its text continuously.
 */
public class VolumeText extends DynamicShowCaseTextField implements UpdateExposer {

    private RideTheLightningScene rideTheLightningScene;

    public VolumeText(final Coordinate2D initialPosition, final RideTheLightningScene rideTheLightningScene) {
        super(initialPosition, "Volume");
        this.rideTheLightningScene = rideTheLightningScene;
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        setValue(String.format("%1$, .4f", rideTheLightningScene.getBackgroundAudioVolume()));
    }
}
