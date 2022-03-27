package com.epicness.factorydude.game.logic.enemies;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.factorydude.game.stuff.waves.Wave;
import com.epicness.fundamentals.logic.SharedLogic;

public class WaveHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float time;
    private int waveIndex;
    private Wave currentWave;
    private boolean allEnemiesSpawned;

    public void startWave(int wave) {
        time = 0f;
        waveIndex = wave;
        currentWave = stuff.getWaveStorage().getWaves()[waveIndex];
        allEnemiesSpawned = false;
        logic.getWaveAnnouncer().announceWave(waveIndex + 1);
    }

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        if (allEnemiesSpawned) {
            return;
        }
        time += delta;
        if (time >= currentWave.getSize()) {
            allEnemiesSpawned = true;
            return;
        }
        int quantity = currentWave.getQuantityAtTime(time);
        for (int i = 0; i < quantity; i++) {
            logic.getEnemySpawner().spawnEnemy();
        }
    }

    public void checkEnemies() {
        DelayedRemovalArray<Enemy> enemies = stuff.getEnemies();
        if (enemies.size <= 1 && allEnemiesSpawned) {
            nextWave();
        }
    }

    public void nextWave() {
        waveIndex++;
        Wave[] waves = stuff.getWaveStorage().getWaves();
        if (waveIndex == waves.length) {
            // TODO: 27/3/2022 GAME WON
            System.out.println("WIN");
            return;
        }
        startWave(waveIndex);
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