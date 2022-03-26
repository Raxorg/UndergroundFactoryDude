package com.epicness.factorydude.game.stuff;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.factorydude.game.stuff.waves.WaveStorage;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.grid.Grid;

public class GameStuff extends Stuff {

    private WaveStorage waveStorage;
    private Grid background;
    private DelayedRemovalArray<Enemy> enemies;
    private Player player;
    private FactoryZone factoryZone;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        waveStorage = new WaveStorage();

        background = new Grid(14, 7, assets.getBg1());
        background.setCellSize(150f);

        enemies = new DelayedRemovalArray<>();

        player = new Player(assets);

        factoryZone = new FactoryZone(sharedAssets, assets);
    }

    public WaveStorage getWaveStorage() {
        return waveStorage;
    }

    public Grid getBackground() {
        return background;
    }

    public DelayedRemovalArray<Enemy> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public FactoryZone getFactoryZone() {
        return factoryZone;
    }
}