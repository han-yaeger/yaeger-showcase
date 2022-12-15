package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.showcase.scenes.burnthewitch.BurnTheWitchScene;


/**
 * The {@code Witch} uses many instances of {@link Animation} to encapsulate animations, which are part
 * of the spritesheet. We use all different implementations of {@link Animation}. Some will loop, some will
 * automatically load another {@link Animation} when its done, and some will call a method at the end
 * of its cycle.
 * <p>
 * Another thing to note is the fact that the bounding box of the {@code Witch} is a bit to large. To fix this,
 * the witch should be made part of a {@link DynamicCompositeEntity}, but since this is only the showcase, it
 * would make it a bit to complex.
 */
public class Witch extends DynamicSpriteEntity {

    private final Animation idleLeftAnimation = new LoopingAnimation(3, 1, 3, 12);
    private final Animation idleRightAnimation = new LoopingAnimation(3, 13, 4, 9);
    // Attack animations are defined in the constructor, since it needs a callback, which needs a reference to "this".
    private final Animation attackLeftAnimation;
    private final Animation attackRightAnimation;
    // Death animations are defined in the constructor, since it needs a callback, which needs a reference to "this".
    private final Animation deathLeftAnimation;
    private final Animation deathRightAnimation;
    // Run animations
    private final Animation runLeftAnimation = new LoopingAnimation(6, 13, 7, 11);
    private final Animation runRightAnimation = new LoopingAnimation(7, 13, 8, 11);
    // Hit animations
    private final Animation hitLeftAnimation = new LinkedAnimation(2, 9, 3, 12, idleLeftAnimation);
    private final Animation hitRightAnimation = new LinkedAnimation(2, 13, 3, 16, idleRightAnimation);

    // Jump attack animations are defined in the constructor, since it needs a callback, which needs a reference to "this".
    private final Animation jumpAttackLeftAnimation;
    private final Animation jumpAttackRightAnimation;
    // Jump animation
    private final Animation jumpLeftAnimation = new LinkedAnimation(4, 15, 5, 12, 60, runLeftAnimation);
    private final Animation jumpRightAnimation = new LinkedAnimation(5, 14, 6, 11, 60, runRightAnimation);

    private BurnTheWitchScene zombieScene;

    public Witch(final Coordinate2D initialLocation, final BurnTheWitchScene zombieScene, final WitchComposition composition) {
        super("entities/witch-spritesheet.png", initialLocation, 9, 16);

        this.zombieScene = zombieScene;

        playAnimation(idleRightAnimation);

        // Since the callback needs to call methods on the Witch, we pass this to its constructor
        var callback = new WitchDeathCallBack(composition);
        deathLeftAnimation = new FiniteAnimationWithCallBack(1, 4, 1, 13, callback);
        deathRightAnimation = new FiniteAnimationWithCallBack(1, 14, 2, 7, callback);

        var magicSpellCallback = new MagicSpellCallback(zombieScene, composition);
        attackLeftAnimation = new LinkedAnimationWithCallBack(0, 0, 0, 9, idleLeftAnimation, magicSpellCallback);
        attackRightAnimation = new LinkedAnimationWithCallBack(0, 10, 1, 3, idleRightAnimation, magicSpellCallback);

        jumpAttackLeftAnimation = new LinkedAnimationWithCallBack(4, 10, 4, 11, idleLeftAnimation, magicSpellCallback);
        jumpAttackRightAnimation = new LinkedAnimationWithCallBack(4, 12, 4, 13, idleRightAnimation, magicSpellCallback);
    }

    protected void jumpRight() {
        playAnimation(jumpRightAnimation);
    }

    protected void jumpLeft() {
        playAnimation(jumpLeftAnimation);
    }

    protected void runRight() {
        playAnimation(runRightAnimation);
    }

    protected void runLeft() {
        playAnimation(runLeftAnimation);
    }

    protected void idleLeft() {
        playAnimation(idleLeftAnimation);
    }

    protected void idleRight() {
        playAnimation(idleRightAnimation);
    }

    protected void attackRight() {
        playAnimation(attackRightAnimation);
    }

    protected void attackLeft() {
        playAnimation(attackLeftAnimation);
    }

    protected void attackJumpRight() {
        playAnimation(jumpAttackRightAnimation);
    }

    protected void attackJumpLeft() {
        playAnimation(jumpAttackLeftAnimation);
    }
}
