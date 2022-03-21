package com.epicness.factorydude.game.stuff;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff {

    private Sprited player;
    private FactoryZone factoryZone;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;
        player = new Sprited(assets.getPlayer());

        factoryZone = new FactoryZone(sharedAssets, assets);
    }

    public Sprited getPlayer() {
        return player;
    }

    public FactoryZone getFactoryZone() {
        return factoryZone;
    }
}