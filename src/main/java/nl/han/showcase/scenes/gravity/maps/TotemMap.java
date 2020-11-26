package nl.han.showcase.scenes.gravity.maps;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import nl.han.showcase.scenes.gravity.maps.totems.Totem1N;
import nl.han.showcase.scenes.gravity.maps.totems.Totem1S;
import nl.han.showcase.scenes.gravity.maps.totems.Totem2N;
import nl.han.showcase.scenes.gravity.maps.totems.Totem2S;

public class TotemMap extends TileMap {

    // Empty tile
    private static final int NIL = 0;

    // Totems
    private static final int T1S = 1;
    private static final int T1N = 2;
    private static final int T2S = 3;
    private static final int T2N = 4;

    public TotemMap(final Coordinate2D location, final Size size) {
        super(location, size);
    }

    @Override
    public void setupEntities() {
        addEntity(T1S, Totem1S.class);
        addEntity(T1N, Totem1N.class);
        addEntity(T2S, Totem2S.class);
        addEntity(T2N, Totem2N.class);
    }

    @Override
    public int[][] defineMap() {
        int[][] map = {
                {T1N},
                {T2S},
                {T2N},
                {T1S}};

        return map;
    }
}
