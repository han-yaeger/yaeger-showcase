package nl.han.showcase.scenes.distance;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.scenes.EntitySpawnerContainer;
import com.github.hanyaeger.api.engine.userinput.*;
import javafx.scene.input.MouseButton;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.distance.entities.*;

/**
 * A common Use Case in games is shooting at something. To know where to shoot, you will need to
 * aim in the right direction. This {@link com.github.hanyaeger.api.engine.scenes.YaegerScene} is
 * a demonstration of that Use Case.
 * <p>
 * The user is able to control a SpaceShip, which is just a {@link com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity}
 * that listens to user input. A Rocket Launcher, which consists of several Entities, calculates the distance and angle
 * to the SpaceShip and shoots rockets.
 */
public class TheDistanceScene extends ShowCaseScene implements MouseButtonPressedListener, MouseButtonReleasedListener, MouseEnterListener, MouseExitListener, MouseMovedListener, EntitySpawnerContainer {

    private RocketSpawner rocketSpawner;

    public TheDistanceScene(final YaegerShowCase yaegerShowCase) {
        super(yaegerShowCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/distance.jpg");

        // We instantiate the rocketspawner at this early stage, so we can pass it
        // to the antiAircraftLauncher.
        rocketSpawner = new RocketSpawner(new Coordinate2D(getWidth() / 2, getHeight()));
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var spaceShip = new SpaceShip(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        spaceShip.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(spaceShip);

        addAntiAircraftGun(spaceShip);
    }

    /**
     * The anti aircraft gun is a composition of several different Entities, which are added individually
     * to the Scene. This is of cours rather ugly, since a composition as such should be mirrored by a
     * composite structure. When Issue #101 is resolved, this code will be changed to use a composite Entity.
     *
     * @param spaceShip the {@link SpaceShip} that needs to be followed
     */
    private void addAntiAircraftGun(final SpaceShip spaceShip) {
        var antiAircraftBase = new AntiAircraftBase(new Coordinate2D(getWidth() / 2, getHeight()));
        addEntity(antiAircraftBase);

        var antiAircraftLauncher = new AntiAircraftLauncher(new Coordinate2D(getWidth() / 2, getHeight()), spaceShip, rocketSpawner);
        addEntity(antiAircraftLauncher);

        var distanceText = new DistanceText(new Coordinate2D(getWidth() / 2 + 60, getHeight() - 60), antiAircraftBase, spaceShip);
        addEntity(distanceText);

        var angleText = new AngleText(new Coordinate2D(getWidth() / 2 + 60, getHeight() - 40), antiAircraftBase, spaceShip);
        addEntity(angleText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(rocketSpawner);
    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        System.out.println("Scene reporting MouseMoved: (" + coordinate2D.getX() + ", " + coordinate2D.getY() + ")");
    }

    @Override
    public void onMouseEntered() {
        System.out.println("The Mouse Pointer has entered the Scene");
    }

    @Override
    public void onMouseExited() {
        System.out.println("The Mouse Pointer has exited the scene");
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, final Coordinate2D coordinate2D) {
        System.out.println("The Mouse Button has been pressed: " + button);
    }

    @Override
    public void onMouseButtonReleased(MouseButton button, final Coordinate2D coordinate2D) {
        System.out.println("The Mouse Button has been release: " + button);
    }
}
