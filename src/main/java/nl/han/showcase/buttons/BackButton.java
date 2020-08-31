package nl.han.showcase.buttons;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import nl.han.showcase.YaegerShowCase;

/**
 * Just a simple {@link com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity}
 * that is used as a button.
 */
public class BackButton extends SelectionButton {

    public static final String BACK = "Back";

    public BackButton(final double y, final YaegerShowCase showCase) {
        super(y, BACK, showCase, YaegerShowCase.SCENE_SELECTION);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }
}
