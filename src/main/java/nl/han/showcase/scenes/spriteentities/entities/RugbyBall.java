package nl.han.showcase.scenes.spriteentities.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.WithTimers;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import nl.han.showcase.scenes.spriteentities.entities.timers.RugbyBallTimer;

public class RugbyBall extends DynamicSpriteEntity implements WithTimers {

    public RugbyBall(final Location location) {
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
