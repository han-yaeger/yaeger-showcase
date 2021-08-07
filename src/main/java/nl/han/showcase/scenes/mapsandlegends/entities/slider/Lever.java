package nl.han.showcase.scenes.mapsandlegends.entities.slider;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseDraggedListener;
import nl.han.showcase.YaegerShowCase;

public class Lever extends RectangleEntity implements MouseDraggedListener {

    private final Slider slider;

    public Lever(final Coordinate2D initialPosition, final Size size, final Slider slider) {
        super(initialPosition, size);
        this.slider = slider;
        setFill(YaegerShowCase.HAN_RED);
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setStrokeWidth(1);
        setStrokeColor(YaegerShowCase.HAN_RED);
    }

    @Override
    public void onDragged(final Coordinate2D coordinate2D) {
        if (coordinate2D.getX() > Slider.LEVER_WIDTH / 2 && coordinate2D.getX() < Slider.WIDTH - (Slider.LEVER_WIDTH / 2)) {
            setAnchorLocationX(coordinate2D.getX());
            slider.setValue(getAnchorLocation().getX() / Slider.WIDTH);
        }
    }

    @Override
    public void onDropped(final Coordinate2D coordinate2D) {
        // Not required
    }
}
