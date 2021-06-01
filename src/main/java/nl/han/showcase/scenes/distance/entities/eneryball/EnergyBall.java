package nl.han.showcase.scenes.distance.entities.eneryball;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EnergyBall extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, TimerContainer {

    public EnergyBall(final Coordinate2D location, final double direction) {
        super("entities/energyball.png", location, new Size(20), 1, 9);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(8, direction);
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        remove();
    }

    @Override
    public void setupTimers() {
        addTimer(new EnergyBallTimer(this));
    }
}
