package com.epicness.factorydude.game.logic.factoryzone;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.cellables.ConveyorBelt;

public class ConveyorHandler {

    // Structure
    private GameStuff stuff;

    public void rotateConveyor(ConveyorBelt conveyorBelt) {
        conveyorBelt.setRotation(conveyorBelt.getRotation() + 60f);
    }

    public void update(float delta) {

    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}