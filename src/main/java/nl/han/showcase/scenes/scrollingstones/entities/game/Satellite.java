package nl.han.showcase.scenes.scrollingstones.entities.game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.han.showcase.scenes.scrollingstones.ScrollingStones;

import java.util.List;

public class Satellite extends DynamicSpriteEntity implements Collided {

    private ScrollingStones scrollingStones;

    public Satellite(final Coordinate2D initialLocation, final Size size, final ScrollingStones scrollingStones) {
        super("entities/satellite.png", initialLocation, size);
        this.scrollingStones = scrollingStones;
        setRotationSpeed(0.2);
    }

    @Override
    public void onCollision(final List<Collider> collidingObjects) {
        scrollingStones.addExplosion(getAnchorLocation(), getSpeed(), getDirection());
        remove();
    }
}
