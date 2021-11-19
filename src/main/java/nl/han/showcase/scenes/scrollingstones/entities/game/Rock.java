package nl.han.showcase.scenes.scrollingstones.entities.game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.shared.explosion.ExplosionAdder;

import java.util.List;

public abstract class Rock extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {

    private ExplosionAdder explosionAdder;

    public Rock(final String resource, final Coordinate2D initialLocation, final Size size, final int rows, final int columns, final ExplosionAdder explosionAdder) {
        super(resource, initialLocation, size, rows, columns);
        this.explosionAdder = explosionAdder;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        remove();
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        explosionAdder.addExplosion(getAnchorLocation(), getSpeed(), getDirection());
        remove();
    }
}
