package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import nl.han.showcase.scenes.spriteentities.entities.timers.RugbyBallTimer;

public class PinkBall extends DynamicSpriteEntity implements TimerContainer {

    public PinkBall(final Coordinate2D location) {
        super("entities/ball-pink.png", location, new Size(60, 60), 0);
        setRotationSpeed(7);
    }

    @Override
    public void setupTimers() {
        addTimer(new RugbyBallTimer(this, 1000));
    }

    public void changeDirection() {
        setRotationSpeed(getRotationSpeed() * -1);
    }
}
