package nl.han.showcase.scenes;

import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import javafx.scene.input.KeyCode;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;

import java.util.Set;

public abstract class ShowCaseScene extends DynamicScene implements KeyListener {

    protected YaegerShowCase showCase;

    public ShowCaseScene(final YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(getHeight() - 30, showCase);
        addEntity(backButton);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT0)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_SELECTION);
        }
    }
}
