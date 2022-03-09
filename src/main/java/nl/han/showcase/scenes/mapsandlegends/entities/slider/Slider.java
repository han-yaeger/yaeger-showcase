package nl.han.showcase.scenes.mapsandlegends.entities.slider;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.TileMap;
import nl.han.showcase.scenes.composing.entities.blackboard.Circle;

public abstract class Slider extends CompositeEntity {

    public static final double WIDTH = 60D;
    public static final double LEVER_WIDTH = 8D;
    private final TileMap map;
    private final String label;

    public Slider(final Coordinate2D initialLocation, final TileMap map, final String label) {
        super(initialLocation);
        this.map = map;
        this.label = label;
    }

    @Override
    protected void setupEntities() {
        var container = new Container(new Coordinate2D(0, 18), new Size(WIDTH, 4));
        addEntity(container);

        var lever = new Lever(new Coordinate2D(WIDTH / 2, 8), new Size(LEVER_WIDTH, 20), this);
        addEntity(lever);

        var labelEntity = new TextEntity(new Coordinate2D(), label);
        labelEntity.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addEntity(labelEntity);
    }

    protected void setValue(final double value) {
        for (var i = 0; i < getMap().getInstanceMap().length; i++) {
            for (var j = 0; j < getMap().getInstanceMap()[i].length; j++) {
                if (getMap().getInstanceMap()[i][j] != null) {
                    applyValue(getMap().getInstanceMap()[i][j], value);
                }
            }
        }
    }

    abstract void applyValue(final YaegerEntity yaegerEntity, final double value);

    public TileMap getMap() {
        return map;
    }
}
