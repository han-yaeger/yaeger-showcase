package nl.han.showcase.scenes.distance.entities.energyball;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

public class Explosion extends DynamicSpriteEntity implements TimerContainer {

    private int frameIndex = 0;

    public Explosion(Coordinate2D initialLocation) {
        super("entities/explosion.png", initialLocation, new Size(90, 90), 1, 7);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        new SoundClip("audio/boom.wav").play();
    }

    public void updateFrame() {
        if (getCurrentFrameIndex() < getFrames() - 1) {
            frameIndex++;
            setCurrentFrameIndex(frameIndex);
        } else {
            remove();
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new ExplosionTimer(this));
    }
}
