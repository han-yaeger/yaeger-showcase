package com.github.hanyaeger.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class RemoveableEntityForTileMap extends SpriteEntity implements MouseButtonPressedListener {

    public RemoveableEntityForTileMap(final Coordinate2D location, final Size size) {
        super("entities/delete.png", location, size);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        remove();
    }
}
