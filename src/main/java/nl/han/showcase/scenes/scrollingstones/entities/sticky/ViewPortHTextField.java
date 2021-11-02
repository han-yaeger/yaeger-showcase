package nl.han.showcase.scenes.scrollingstones.entities.sticky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import nl.han.showcase.shared.textfield.DynamicShowCaseTextField;

public class ViewPortHTextField extends DynamicShowCaseTextField implements UpdateExposer {

    private ScrollableDynamicScene scene;

    public ViewPortHTextField(Coordinate2D initialLocation, ScrollableDynamicScene scene) {
        super(initialLocation, "ViewPort H value");
        this.scene = scene;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        setValue(String.valueOf(scene.getHorizontalScrollPosition()));
    }
}
