package nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class GrassEntity extends SpriteEntity {

    public GrassEntity(Coordinate2D location, Size size) {
        super(GrassType.SIMPLE.sprite, location, size);
    }

    public GrassEntity(Coordinate2D location, Size size, GrassType grassType) {
        super(grassType.sprite, location, size);
    }

    public enum GrassType {
        SIMPLE("entities/grass_simple.png"),
        COMPLEX("entities/grass_complex.png"),
        SHORT("entities/grass_short.png"),
        LONG("entities/grass_long.png"),
        DEAD("entities/grass_dead.png");

        String sprite;

        GrassType(String sprite) {
            this.sprite = sprite;
        }
    }
}
