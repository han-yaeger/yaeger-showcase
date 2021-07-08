package nl.han.showcase.scenes.time.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.text.DynamicTextEntity;
import nl.han.showcase.scenes.time.spawners.ClockSpawner;
import nl.han.showcase.shared.textfield.DynamicShowCaseTextField;

/**
 * A simple {@link DynamicTextEntity} that implements the interface {@link UpdateExposer}
 * to update its text continuously.
 */
public class SpawnerIntervalText extends DynamicShowCaseTextField implements UpdateExposer {

    private ClockSpawner clockSpawner;

    public SpawnerIntervalText(final Coordinate2D initialPosition, final ClockSpawner clockSpawner) {
        super(initialPosition, "Spawner int. (ms)");
        this.clockSpawner = clockSpawner;
        setAnchorPoint(AnchorPoint.TOP_RIGHT);
        // Ensure it is placed before the falling clocks
        setViewOrder(1);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        setValue(String.valueOf(clockSpawner.getIntervalInMs()));
    }
}
