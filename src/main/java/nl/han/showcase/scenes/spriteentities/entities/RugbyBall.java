package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import nl.han.showcase.scenes.spriteentities.entities.timers.RugbyBallTimer;

public class RugbyBall extends DynamicSpriteEntity implements TimerContainer {

    public RugbyBall(final Coordinate2D location) {
        super("entities/rugbyball.png", location, new Size(60, 60), 0);
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
