package com.github.hanyaeger.showcase.scenes.distance;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.userinput.*;
import com.github.hanyaeger.showcase.scenes.distance.entities.*;
import com.github.hanyaeger.showcase.scenes.distance.entities.dragndrop.Draggable;
import com.github.hanyaeger.showcase.scenes.distance.entities.dragndrop.DropArea;
import com.github.hanyaeger.showcase.shared.explosion.Explosion;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.ShowCaseScene;
import com.github.hanyaeger.showcase.shared.explosion.ExplosionAdder;
import com.github.hanyaeger.showcase.shared.textfield.ShowCaseTextField;

/**
 * A common Use Case in games is shooting at something. To know where to shoot, you will need to
 * aim in the right direction. This {@link com.github.hanyaeger.api.scenes.DynamicScene} is
 * a demonstration of that Use Case.
 * <p>
 * The user is able to control a SpaceShip, which is just a {@link com.github.hanyaeger.api.entities.impl.DynamicCircleEntity}
 * that listens to mouse movements. While the mouse pointer is within the Scene, the SpaceShip is placed on the location
 * of the mouse pointer. To enable this behavior, the SpaceShip implements the interface {@link MouseMovedListener}.
 * <p>
 * A Rocket Launcher, which consists of several Entities, calculates the distance and angle
 * to the SpaceShip and shoots rockets.
 * <p>
 * The Scene itself also implements many of the mouse-related listeners, who's information is displayed through a
 * {@link com.github.hanyaeger.api.entities.CompositeEntity} that demonstrates hoe to create re-usable components.
 * <p>
 */
public class TheDistanceScene extends ShowCaseScene implements MouseButtonPressedListener, MouseButtonReleasedListener, MouseEnterListener, MouseExitListener, MouseMovedListener, EntitySpawnerContainer, MouseMovedWhileDraggingListener, ExplosionAdder {

    private static final double CONTROL_AREA_MARGIN = 140D;
    private static final double TEXTFIELD_MARGIN = 20D;
    private static final double TEXTFIELD_DELTA = 50D;
    private static final String PRESSED = "PRESSED";
    private static final String RELEASED = "RELEASED";
    private RocketSpawner rocketSpawner;

    private ShowCaseTextField mousePointerTextField;
    private ShowCaseTextField mouseInSceneTextField;
    private ShowCaseTextField primaryButtonPressedTextField;
    private ShowCaseTextField secondaryButtonPressedTextField;
    private ShowCaseTextField mousePointerWhileDraggedTextField;

    public TheDistanceScene(final YaegerShowCase yaegerShowCase) {
        super(yaegerShowCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/distance.jpg");

        // We instantiate the rocket spawner at this early stage, so we can pass it
        // to the antiAircraftLauncher.
        rocketSpawner = new RocketSpawner(new Coordinate2D(getWidth() / 2, getHeight()), this);
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var controlArea = new ControlArea(new Coordinate2D(getWidth() / 2, getHeight() / 2),
                new Size(getWidth() - 2 * CONTROL_AREA_MARGIN, getHeight() - 2 * CONTROL_AREA_MARGIN));
        addEntity(controlArea);

        mousePointerTextField = new ShowCaseTextField(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN), "Mouse pointer");
        mousePointerTextField.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(mousePointerTextField);

        mousePointerWhileDraggedTextField = new ShowCaseTextField(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN + TEXTFIELD_DELTA), "Mouse dragging");
        mousePointerWhileDraggedTextField.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(mousePointerWhileDraggedTextField);

        mouseInSceneTextField = new ShowCaseTextField(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN + 2 * TEXTFIELD_DELTA), "Mouse in Scene?");
        mouseInSceneTextField.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(mouseInSceneTextField);

        primaryButtonPressedTextField = new ShowCaseTextField(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN + 3 * TEXTFIELD_DELTA), "Primary Button", RELEASED);
        primaryButtonPressedTextField.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(primaryButtonPressedTextField);

        secondaryButtonPressedTextField = new ShowCaseTextField(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN + 4 * TEXTFIELD_DELTA), "Secondary Button", RELEASED);
        secondaryButtonPressedTextField.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(secondaryButtonPressedTextField);

        var dropArea = new DropArea(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN + 5 * TEXTFIELD_DELTA), new Size(100, 150), rocketSpawner);
        dropArea.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(dropArea);

        var draggableOne = new Draggable(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN, CONTROL_AREA_MARGIN + 410), Color.AQUA, 0, 0);
        draggableOne.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(draggableOne);

        var draggableTwo = new Draggable(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN - 100, CONTROL_AREA_MARGIN + 410), Color.RED, -1, -1);
        draggableTwo.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(draggableTwo);

        var draggableThree = new Draggable(new Coordinate2D(getWidth() - TEXTFIELD_MARGIN - 50, CONTROL_AREA_MARGIN + 410), Color.YELLOW, 1, 1);
        draggableThree.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(draggableThree);

        var spaceShip = new SpaceShip(new Coordinate2D(getWidth() / 2, getHeight() / 2), controlArea);
        spaceShip.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(spaceShip);

        addAntiAircraftGun(spaceShip);
    }

    /**
     * The anti-aircraft gun is a composition of several different Entities, which are added individually
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

        var distanceText = new DistanceText(new Coordinate2D(getWidth() / 2 + 180, getHeight() - 60), antiAircraftBase, spaceShip);
        addEntity(distanceText);

        var angleText = new AngleText(new Coordinate2D(getWidth() / 2 + 300, getHeight() - 60), antiAircraftBase, spaceShip);
        addEntity(angleText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(rocketSpawner);
    }

    @Override
    public void onMouseMoved(final Coordinate2D coordinate2D) {
        mousePointerTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
    }

    @Override
    public void onMouseMovedWhileDragging(final Coordinate2D coordinate2D) {
        mousePointerWhileDraggedTextField.setValue(("(" + Math.round(coordinate2D.getX()) + ", " + Math.round(coordinate2D.getY()) + ")"));
    }

    @Override
    public void onMouseEntered() {
        mouseInSceneTextField.setValue("YES");
    }

    @Override
    public void onMouseExited() {
        mouseInSceneTextField.setValue("NO");
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        switch (button) {
            case PRIMARY -> primaryButtonPressedTextField.setValue(PRESSED);
            case SECONDARY -> secondaryButtonPressedTextField.setValue(PRESSED);
        }
    }

    @Override
    public void onMouseButtonReleased(final MouseButton button, final Coordinate2D coordinate2D) {
        switch (button) {
            case PRIMARY -> primaryButtonPressedTextField.setValue(RELEASED);
            case SECONDARY -> secondaryButtonPressedTextField.setValue(RELEASED);
        }
    }

    @Override
    public void addExplosion(final Coordinate2D anchorLocation, double speed, double direction) {
        addEntity(new Explosion(anchorLocation));
    }
}
