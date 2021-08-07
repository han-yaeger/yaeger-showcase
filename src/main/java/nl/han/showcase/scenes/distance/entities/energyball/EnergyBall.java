package nl.han.showcase.scenes.distance.entities.energyball;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.scenes.distance.TheDistanceScene;

public class EnergyBall extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided, TimerContainer {

    private TheDistanceScene theDistanceScene;

    public EnergyBall(final Coordinate2D location, final double direction, final TheDistanceScene theDistanceScene) {
        super("entities/energyball.png", location, new Size(20), 1, 9);
        this.theDistanceScene = theDistanceScene;

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(10, direction);

        new SoundClip("audio/laser.mp3").play();
    }

    @Override
    public void notifyBoundaryCrossing(final SceneBorder border) {
        remove();
    }

    public void explode() {
        theDistanceScene.explode(getAnchorLocation());
    }

    @Override
    public void setupTimers() {
        addTimer(new EnergyBallTimer(this));
    }

    @Override
    public void onCollision(Collider collidingObject) {
        remove();
        explode();
    }
}
