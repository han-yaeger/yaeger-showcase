package nl.han.showcase.scenes;

import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import javafx.scene.input.KeyCode;
import nl.han.showcase.YaegerShowCase;

import java.util.Set;

public abstract class ShowCaseScene extends DynamicScene implements KeyListener {

    /**
     * Return the YaegerShowCase Game
     *
     * @return An instance of {@link YaegerShowCase}
     */
    public abstract YaegerShowCase getShowCase();

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT0)) {
            getShowCase().setActiveScene(YaegerShowCase.SCENE_SELECTION);
        }
    }
}
