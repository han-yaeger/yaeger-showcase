package nl.han.showcase.scenes.scrollingstones.entities.game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Earth extends DynamicSpriteEntity {

    public Earth(Coordinate2D initialLocation) {
        super("entities/earth.png", initialLocation, 12, 5);
        setAutoCycle(80);
    }
}
