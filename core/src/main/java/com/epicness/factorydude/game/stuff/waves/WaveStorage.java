package com.epicness.factorydude.game.stuff.waves;

public class WaveStorage {

    private final Wave[] waves;

    public WaveStorage() {
        waves = new Wave[1];
        int[] waveNodes = new int[30];
        waveNodes[7] = 1;
        waveNodes[14] = 3;
        waveNodes[21] = 5;
        waveNodes[29] = 7;
        waves[0] = new Wave(waveNodes);
    }

    public Wave[] getWaves() {
        return waves;
    }
}