package com.epicness.factorydude.game.assets;

import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_PATH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    private Sprite player;

    @Override
    public void queueAssetLoading() {
        loadTexture(PLAYER_PATH);
    }

    @Override
    public void initializeAssets() {
        player = new Sprite(getTexture(PLAYER_PATH));
    }

    public Sprite getPlayer() {
        return player;
    }
}