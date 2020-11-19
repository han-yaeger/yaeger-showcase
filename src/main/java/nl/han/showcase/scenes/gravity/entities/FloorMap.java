package nl.han.showcase.scenes.gravity.entities;

import com.github.hanyaeger.api.engine.entities.tilemap.TileMap;
import nl.han.showcase.scenes.gravity.entities.other.Grass;
import nl.han.showcase.scenes.gravity.entities.other.Roots;
import nl.han.showcase.scenes.gravity.entities.walls.*;

/**
 * A rather large {@link TileMap} is used to create the floor, including decorations.
 */
public class FloorMap extends TileMap {

    // Constants are used for the id Entities in the Map
    private static final int NIL = 0;
    private static final int NE1 = 1;
    private static final int NW1 = 2;
    private static final int SE1 = 3;
    private static final int SW1 = 4;
    private static final int NE2 = 5;
    private static final int NW2 = 6;
    private static final int SE2 = 7;
    private static final int SW2 = 8;
    private static final int NE3 = 9;
    private static final int NW3 = 10;
    private static final int SE3 = 11;
    private static final int SW3 = 12;
    private static final int NE4 = 13;
    private static final int NW4 = 14;
    private static final int SE4 = 15;
    private static final int SW4 = 16;
    private static final int NE5 = 17;
    private static final int NW5 = 18;
    private static final int SE5 = 19;
    private static final int SW5 = 20;
    private static final int GRS = 21;
    private static final int ROT = 22;

    @Override
    public void setupEntities() {

        addEntity(NE1, Wall1NE.class);
        addEntity(NW1, Wall1NW.class);
        addEntity(SE1, Wall1SE.class);
        addEntity(SW1, Wall1SW.class);
        addEntity(NE2, Wall2NE.class);
        addEntity(NW2, Wall2NW.class);
        addEntity(SE2, Wall2SE.class);
        addEntity(SW2, Wall2SW.class);
        addEntity(NE3, Wall3NE.class);
        addEntity(NW3, Wall3NW.class);
        addEntity(SE3, Wall3SE.class);
        addEntity(SW3, Wall3SW.class);
        addEntity(NE4, Wall4NE.class);
        addEntity(NW4, Wall4NW.class);
        addEntity(SE4, Wall4SE.class);
        addEntity(SW4, Wall4SW.class);
        addEntity(NE5, Wall5NE.class);
        addEntity(NW5, Wall5NW.class);
        addEntity(SE5, Wall5SE.class);
        addEntity(SW5, Wall5SW.class);
        addEntity(GRS, Grass.class);
        addEntity(ROT, Roots.class);
    }

    @Override
    public int[][] defineMap() {
        int[][] map = {
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, NIL, GRS, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, NW1, NE2, NW2, NE1, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NIL, SW3, SE5, SE2, SE1, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, NW1, NW5, SE3, ROT, ROT, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, SW1, SW5, SE3, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, NIL, NIL, NIL, NIL, NIL, ROT, SW3, SE3, NIL, NIL, NIL, NIL, NIL, NIL},
                {NIL, GRS, NIL, NIL, NIL, NIL, NIL, SW3, SE3, NIL, NIL, NIL, NIL, NIL, NIL},
                {NE2, NW2, NE2, NW2, NE1, NIL, NIL, SW3, SE3, NIL, NIL, NIL, NIL, NIL, NIL},
                {NE4, NW4, NE4, NW4, SE3, NIL, NIL, SW3, SE3, NIL, NIL, NIL, NIL, NIL, NIL}
        };
        return map;
    }
}
