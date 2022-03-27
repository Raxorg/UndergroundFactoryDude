package com.epicness.factorydude.game.stuff.waves;

public class WaveStorage {

    private final Wave[] waves;

    public WaveStorage() {
        waves = new Wave[5];
        int[] waveNodes = new int[1];
        waveNodes[0] = 1;
        waves[0] = new Wave(waveNodes);
        waveNodes = new int[5];
        waveNodes[0] = 1;
        waveNodes[4] = 3;
        waves[1] = new Wave(waveNodes);
        waveNodes = new int[15];
        waveNodes[0] = 1;
        waveNodes[4] = 3;
        waveNodes[9] = 5;
        waveNodes[14] = 7;
        waves[2] = new Wave(waveNodes);
        waveNodes = new int[30];
        waveNodes[0] = 3;
        waveNodes[7] = 5;
        waveNodes[14] = 7;
        waveNodes[21] = 9;
        waveNodes[29] = 11;
        waves[3] = new Wave(waveNodes);
        waveNodes = new int[60];
        addEnemyPerN(waveNodes, 1);
        addEnemyPerN(waveNodes, 3);
        addEnemyPerN(waveNodes, 6);
        addEnemyPerN(waveNodes, 12);
        addEnemyPerN(waveNodes, 30);
        waves[4] = new Wave(waveNodes);
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