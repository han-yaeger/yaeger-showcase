package nl.han.showcase.scenes.roadsgoeveron.entities;

import com.github.hanyaeger.api.engine.TimerContainer;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.scenes.roadsgoeveron.entities.timers.TimedDynamicTextTimer;

import java.util.Arrays;
import java.util.List;

public class TimedDynamicTextEntity extends DynamicTextEntity implements TimerContainer {

    private int currentLine = 0;

    private static final List<String> theRoadGoesEverOn = Arrays.asList(new String[]{
            "Roads go ever ever on,",
            "Over rock and under tree,",
            "By caves where never sun has shone,",
            "By streams that never find the sea;",
            "Over snow by winter sown,",
            "And through the merry flowers of June,",
            "Over grass and over stone,",
            "And under mountains in the moon.",
            " Roads go ever ever on",
            "Under cloud and under star,",
            "Yet feet that wandering have gone.",
            "Turn at last to home afar.",
            "Eyes that fire and sword have seen.",
            "And horror in the halls of stone.",
            "Look at last on meadows green.",
            "And trees and hills they long have known."
    });

    public TimedDynamicTextEntity(final Coordinate2D position) {
        super(position);
        nextLine();
        setFill(Color.SILVER);
        setFont(Font.font("arial", FontWeight.BOLD, 20));
    }

    @Override
    public void setupTimers() {
        addTimer(new TimedDynamicTextTimer(this, 2100));
    }

    public void nextLine() {
        setText(theRoadGoesEverOn.get(currentLine % theRoadGoesEverOn.size()));
        currentLine++;
    }
}
