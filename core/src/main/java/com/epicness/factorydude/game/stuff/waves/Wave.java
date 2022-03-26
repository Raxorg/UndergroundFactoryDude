package com.epicness.factorydude.game.stuff.waves;

public class Wave {

    private final int[] waveNodes;

    public Wave(int[] waveNodes) {
        this.waveNodes = waveNodes;
    }

    public int getSize() {
        return waveNodes.length;
    }

    public int getQuantityAtTime(float time) {
        int quantity = waveNodes[(int) time];
        waveNodes[(int) time] = 0;
        return quantity;
    }
}