package com.github.hanyaeger.showcase.scenes.burnthewitch.entities.witch;

import com.github.hanyaeger.api.entities.AnimationCallback;

public class WitchDeathCallBack implements AnimationCallback {

    private WitchComposition witch;

    public WitchDeathCallBack(final WitchComposition witch){

        this.witch = witch;
    }

    @Override
    public void call() {
        witch.die();
    }
}
