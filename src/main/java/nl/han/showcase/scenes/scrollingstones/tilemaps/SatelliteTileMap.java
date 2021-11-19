package nl.han.showcase.scenes.scrollingstones.tilemaps;

import com.github.hanyaeger.api.scenes.TileMap;
import nl.han.showcase.scenes.scrollingstones.ScrollingStones;
import nl.han.showcase.scenes.scrollingstones.entities.game.Satellite;
import nl.han.showcase.shared.explosion.ExplosionAdder;

import java.util.Random;

public class SatelliteTileMap extends TileMap {

    private ScrollingStones explosionAdder;

    public SatelliteTileMap(final ScrollingStones scrollingStones) {
        this.explosionAdder = scrollingStones;
    }

    @Override
    public void setupEntities() {
        addEntity(1, Satellite.class, explosionAdder);
    }

    @Override
    public int[][] defineMap() {
        // In this method, we programmatically create the two-dimensional array.
        // This way each time we load the scene, the satellites are on a different location

        // The map will be square-shaped, and should be between 20 and 30 entities wide.
        var dimensions = new Random().nextInt(10) + 20;

        // Secondly, we randomly deze how many satellites we want. At least 1.
        var numberOfSatellites = new Random().nextInt(5) + 1;

        // For the third step, we create an empty map of the correct dimensions
        var map = new int[dimensions][dimensions];

        // We use a while-loop to randomly place the satellites in the map
        while (numberOfSatellites > 0) {

            // Create a random coordinate in the map
            var x = new Random().nextInt(dimensions);
            var y = new Random().nextInt(dimensions);

            // Check if that location is already occupied. If so, continue with the next iteration
            if (map[x][y] != 0) {
                continue;
            }

            // Add a satellite to the coordinates
            map[x][y] = 1;

            // Lower the number of satellites that still need to be placed
            numberOfSatellites--;
        }

        return map;
    }
}
