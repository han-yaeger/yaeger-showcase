package com.github.hanyaeger.showcase.scenes.burnthewitch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.*;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch.MagicSpell;
import com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch.WitchComposition;
import com.github.hanyaeger.showcase.YaegerShowCase;
import com.github.hanyaeger.showcase.scenes.ShowCaseScene;

public class BurnTheWitchScene extends ShowCaseScene {

    protected YaegerShowCase showCase;

    public BurnTheWitchScene(final YaegerShowCase yaegerShowCase) {
        super(yaegerShowCase);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/dungeon-platform.png");
    }

    @Override
    public void setupEntities() {
        var bottomFloor = new Floor(new Coordinate2D(0, 670),
                new Size(550, 10));
        addEntity(bottomFloor);

        var wall = new Wall(new Coordinate2D(540, 670), new Size(10, 100));
        addEntity(wall);

        var secondFloor = new Floor(new Coordinate2D(550, 580),
                new Size(500, 10));
        addEntity(secondFloor);

        var fence = new Fence(new Coordinate2D(558, 458));
        addEntity(fence);

        var witch = new WitchComposition(new Coordinate2D(300, 625), this);
        addEntity(witch);

        var bat1 = new Bat(new Coordinate2D(180, 65), witch);
        addEntity(bat1);

        var bat2 = new Bat(new Coordinate2D(380, 75), witch);
        addEntity(bat2);

        var bat3 = new Bat(new Coordinate2D(680, 175), witch);
        addEntity(bat3);

        super.setupEntities();
    }

    public void createMagicSpell(final Coordinate2D coordinate2D, final Direction direction) {
        var magicSpell = new MagicSpell(coordinate2D, direction);
        addEntity(magicSpell);
    }
}
