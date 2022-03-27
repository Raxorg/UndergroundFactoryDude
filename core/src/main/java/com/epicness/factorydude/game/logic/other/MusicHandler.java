package com.epicness.factorydude.game.logic.other;

import com.epicness.factorydude.game.assets.GameAssets;

public class MusicHandler {

    // Structure
    private GameAssets assets;

    public void playMusic() {
        assets.getCaves().setVolume(0.25f);
        assets.getCaves().setLooping(true);
        assets.getCaves().play();
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}