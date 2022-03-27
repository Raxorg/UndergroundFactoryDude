package com.epicness.factorydude.game.stuff.waves;

public class WaveStorage {

    private final Wave[] waves;

    public WaveStorage() {
        waves = new Wave[2];
        int[] waveNodes = new int[30];
        waveNodes[0] = 1;
        waveNodes[7] = 1;
        waveNodes[14] = 3;
        waveNodes[21] = 5;
        waveNodes[29] = 7;
        waves[0] = new Wave(waveNodes);
        waveNodes = new int[60];
        addEnemyPerN(waveNodes, 1);
        addEnemyPerN(waveNodes, 6);
        waves[1] = new Wave(waveNodes);
    }

    private void addEnemyPerN(int[] waveNodes, int n) {
        for (int i = 0; i < waveNodes.length; i += n) {
            waveNodes[i] += 1;
        }
    }

    public Wave[] getWaves() {
        return waves;
    }
}