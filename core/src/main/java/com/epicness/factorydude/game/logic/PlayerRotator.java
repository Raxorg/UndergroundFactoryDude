package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;

public class PlayerRotator {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void init() {
        logic.getPlayerAnimationUpdater().setup(stuff.getPlayer().getCurrentAnimation());
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}