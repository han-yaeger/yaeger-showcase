package nl.han.showcase.scenes.distance.entities.energyball;


import com.github.hanyaeger.api.Timer;

public class EnergyBallTimer extends Timer {

    private int delta = 1;
    private EnergyBall energyBall;

    public EnergyBallTimer(final EnergyBall energyBall) {
        super(50);
        this.energyBall = energyBall;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        if (energyBall.getCurrentFrameIndex() == 0) {
            delta = 1;
        } else if (energyBall.getCurrentFrameIndex() == 8) {
            delta = -1;
        }

        energyBall.setCurrentFrameIndex(energyBall.getCurrentFrameIndex() + delta);
        energyBall.setOpacity(0.2 * energyBall.getCurrentFrameIndex());
    }
}
