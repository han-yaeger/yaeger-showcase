package nl.han.showcase.scenes.scrollingstones.entities.game;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

import java.util.Random;

public class Star extends DynamicCircleEntity implements UpdateExposer {

    private boolean bright = true;
    private final Color brightColor;

    public Star(Coordinate2D initialLocation) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        toggleCollor();
        setRadius(new Random().nextDouble());

        brightColor = new Random().nextBoolean() ? Color.WHITE : Color.GRAY;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        if (new Random().nextBoolean()) {
            toggleCollor();
        }
    }

    private void toggleCollor() {
        if (bright) {
            setFill(Color.DARKGRAY);
            bright = false;
        } else {
            setFill(brightColor);
            bright = true;
        }
    }
}
