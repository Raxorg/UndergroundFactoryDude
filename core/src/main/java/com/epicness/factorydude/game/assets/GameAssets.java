package com.epicness.factorydude.game.assets;

import static com.epicness.factorydude.game.assets.GameAssetPaths.HEX_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_PATH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Sprites
    private Sprite hex;
    private Sprite player;

    @Override
    public void queueAssetLoading() {
        loadTexture(HEX_PATH);
        loadTexture(PLAYER_PATH);
    }

    @Override
    public void initializeAssets() {
        hex = new Sprite(getTexture(HEX_PATH));
        player = new Sprite(getTexture(PLAYER_PATH));
    }

    // Sprites
    public Sprite getHex() {
        return hex;
    }

    public Sprite getPlayer() {
        return player;
    }
}