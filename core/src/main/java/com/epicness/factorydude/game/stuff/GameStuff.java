package com.epicness.factorydude.game.stuff;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.Stuff;

public class GameStuff extends Stuff {

    private Player player;
    private FactoryZone factoryZone;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;
        player = new Player(assets);

        factoryZone = new FactoryZone(sharedAssets, assets);
    }

    public Player getPlayer() {
        return player;
    }

    public FactoryZone getFactoryZone() {
        return factoryZone;
    }
}