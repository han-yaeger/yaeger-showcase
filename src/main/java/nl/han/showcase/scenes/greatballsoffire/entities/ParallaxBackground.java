package nl.han.showcase.scenes.greatballsoffire.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.scenes.greatballsoffire.GreatBallsOfFire;

public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final Size size;
    private final String resource;
    private final Coordinate2D initialLocation;
    private final GreatBallsOfFire scene;
    private final int viewIndex;
    private final double speed;

    public ParallaxBackground(String resource, Coordinate2D initialLocation, Size size, GreatBallsOfFire scene, int viewIndex, double speed) {
        super(resource, initialLocation, size);

        this.resource = resource;
        this.initialLocation = initialLocation;
        this.size = size;
        this.scene = scene;
        this.viewIndex = viewIndex;
        this.speed = speed;

        setViewOrder(viewIndex);
        setPreserveAspectRatio(false);
        setMotion(speed, Direction.LEFT);
    }

    /**
     * Check if the current image middle is touching the left border of the screen.
     * If so add a new image to the screen and anchor it to the initial X location.
     * If an image is of the screen remove it from the scene.
     *
     * @param border Side of the screen
     */
    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

        // Check if middle of image touched boundary, if so spawn new image
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / speed) == -(int) ((this.size.width() / speed) / 2)) {
            var newLocation = new Coordinate2D((this.size.width() / 2), initialLocation.getY());
            scene.addEntity(new ParallaxBackground(resource, newLocation, size, scene, viewIndex, speed));
        }

        // Remove current image from scene if it's past the view
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / speed) == -(int) (this.size.width() / speed)) {
            this.remove();
        }
    }
}
