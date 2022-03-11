package com.github.hanyaeger.showcase.scenes.time.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.showcase.scenes.time.spawners.ClockSpawner;
import com.github.hanyaeger.showcase.shared.buttons.ButtonBackground;
import com.github.hanyaeger.showcase.shared.buttons.ButtonText;

public class SpawningSpeed extends CompositeEntity {

    private static final String TEXT = "Spawning Speed";
    private final ClockSpawner clockSpawner;

    public SpawningSpeed(final Coordinate2D initialLocation, final ClockSpawner clockSpawner) {
        super(initialLocation);
        this.clockSpawner = clockSpawner;
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        // Ensure it is placed before the falling clocks
        setViewOrder(1);
    }

    @Override
    protected void setupEntities() {
        var decrementButton = new DecrementButton(new Coordinate2D(0, 0), clockSpawner);
        addEntity(decrementButton);

        var buttonBackground = new ButtonBackground(new Coordinate2D(40, 0), new Size(170, 36));
        addEntity(buttonBackground);

        var label = new ButtonText(new Coordinate2D(40, 4), TEXT);
        addEntity(label);

        var incrementButton = new IncrementButton(new Coordinate2D(195, 0), clockSpawner);
        addEntity(incrementButton);
    }
}
