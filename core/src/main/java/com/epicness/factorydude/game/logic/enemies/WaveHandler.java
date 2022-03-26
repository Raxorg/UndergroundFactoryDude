package com.epicness.factorydude.game.logic.enemies;

import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.waves.Wave;
import com.epicness.fundamentals.logic.SharedLogic;

public class WaveHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float time;
    private Wave currentWave;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        time += delta;
        Wave wave = stuff.getWaveStorage().getWaves()[0];
        if (time >= wave.getSize()) {
            // TODO: 25/3/2022 next wave
            return;
        }
        int quantity = wave.getQuantityAtTime(time);
        for (int i = 0; i < quantity; i++) {
            logic.getEnemySpawner().spawnEnemy();
        }
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}