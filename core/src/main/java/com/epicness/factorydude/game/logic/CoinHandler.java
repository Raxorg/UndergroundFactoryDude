package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;

public class CoinHandler {

    // Structure
    private GameStuff stuff;

    public void update(float delta) {
        stuff.getCoinCounter().addTime(delta);
    }

    public void addCoin() {
        stuff.getCoinCounter().addCoin();
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}