package com.epicness.factorydude.game.stuff.waves;

public class WaveStorage {

    private final Wave[] waves;

    public WaveStorage() {
        waves = new Wave[1];
        int[] waveNodes = new int[10];
        waveNodes[0] = 1;
        waveNodes[5] = 3;
        waveNodes[9] = 5;
        waves[0] = new Wave(waveNodes);
    }

    public Wave[] getWaves() {
        return waves;
    }
}