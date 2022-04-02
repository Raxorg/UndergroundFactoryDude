package com.epicness.factorydude.game.logic.other;

import com.epicness.factorydude.game.stuff.GameStuff;

public class CoinHandler {

    // Structure
    private GameStuff stuff;

    public void init() {
        stuff.getCoinCounter().setCoins(5);
    }

    public void update(float delta) {
        stuff.getCoinCounter().addTime(delta);
    }

    public int getCoins() {
        return stuff.getCoinCounter().getCoins();
    }

    public void addCoin() {
        stuff.getCoinCounter().setCoins(stuff.getCoinCounter().getCoins() + 1);
    }

    public void subtractCoin() {
        stuff.getCoinCounter().setCoins(stuff.getCoinCounter().getCoins() - 1);
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}