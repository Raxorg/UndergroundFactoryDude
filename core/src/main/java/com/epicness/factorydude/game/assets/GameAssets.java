package com.epicness.factorydude.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.factorydude.game.assets.GameAssetPaths.BG_1;
import static com.epicness.factorydude.game.assets.GameAssetPaths.BG_2;
import static com.epicness.factorydude.game.assets.GameAssetPaths.COIN_FRAMES_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.ENEMY_EAST_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.ENEMY_NORTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.ENEMY_SOUTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.FACTORY_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.HEX_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_EAST_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_EAST_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_NORTH_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_NORTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_SOUTH_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_SOUTH_WALK;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.utils.AnimationUtils;

public class GameAssets extends Assets {

    // Animations
    private Sprite[] playerEastSlash, playerEastWalk,
            playerNorthSlash, playerNorthWalk,
            playerSouthSlash, playerSouthWalk;
    private Sprite[] enemyEastWalk, enemyNorthWalk, enemySouthWalk;
    private Sprite[] coinFrames;
    // Sprites
    private Sprite bg1, bg2;
    private Sprite hex;
    private Sprite factory;

    @Override
    public void queueAssetLoading() {
        // Animations
        loadTexture(PLAYER_EAST_SLASH);
        loadTexture(PLAYER_EAST_WALK);
        loadTexture(PLAYER_NORTH_SLASH);
        loadTexture(PLAYER_NORTH_WALK);
        loadTexture(PLAYER_SOUTH_SLASH);
        loadTexture(PLAYER_SOUTH_WALK);
        loadTexture(ENEMY_EAST_WALK);
        loadTexture(ENEMY_NORTH_WALK);
        loadTexture(ENEMY_SOUTH_WALK);
        loadTexture(COIN_FRAMES_PATH);
        // Sprites
        loadTexture(BG_1);
        loadTexture(BG_2);
        loadTexture(HEX_PATH);
        loadTexture(FACTORY_PATH);
    }

    @Override
    public void initializeAssets() {
        // Animations
        Texture playerEastSlashTex = getTexture(PLAYER_EAST_SLASH);
        playerEastSlash = AnimationUtils.split(playerEastSlashTex, 138, 165, 15);
        Texture playerEastWalkTex = getTexture(PLAYER_EAST_WALK);
        playerEastWalk = AnimationUtils.split(playerEastWalkTex, 138, 165, 15);
        Texture playerNorthSlashTex = getTexture(PLAYER_NORTH_SLASH);
        playerNorthSlash = AnimationUtils.split(playerNorthSlashTex, 138, 165, 10);
        Texture playerNorthWalkTex = getTexture(PLAYER_NORTH_WALK);
        playerNorthWalk = AnimationUtils.split(playerNorthWalkTex, 138, 165, 15);
        Texture playerSouthSlashTex = getTexture(PLAYER_SOUTH_SLASH);
        playerSouthSlash = AnimationUtils.split(playerSouthSlashTex, 138, 165, 14);
        Texture playerSouthWalkTex = getTexture(PLAYER_SOUTH_WALK);
        playerSouthWalk = AnimationUtils.split(playerSouthWalkTex, 138, 165, 12);

        Texture enemyEastWalkTex = getTexture(ENEMY_EAST_WALK);
        enemyEastWalk = AnimationUtils.split(enemyEastWalkTex, 138, 165, 20);
        Texture enemyNorthWalkTex = getTexture(ENEMY_NORTH_WALK);
        enemyNorthWalk = AnimationUtils.split(enemyNorthWalkTex, 138, 165, 20);
        Texture enemySouthWalkTex = getTexture(ENEMY_SOUTH_WALK);
        enemySouthWalk = AnimationUtils.split(enemySouthWalkTex, 138, 165, 20);

        Texture coinFramesTex = getTexture(COIN_FRAMES_PATH);
        coinFrames = AnimationUtils.split(coinFramesTex, 16, 21, 4);
        // Sprites
        bg1 = new Sprite(getTexture(BG_1));
        bg2 = new Sprite(getTexture(BG_2));
        hex = new Sprite(getTexture(HEX_PATH));
        hex.getTexture().setFilter(Linear, Linear);
        factory = new Sprite(getTexture(FACTORY_PATH));
        factory.getTexture().setFilter(Linear, Linear);
    }

    // Animations
    public Sprite[] getPlayerEastSlash() {
        return playerEastSlash;
    }

    public Sprite[] getPlayerEastWalk() {
        return playerEastWalk;
    }

    public Sprite[] getPlayerNorthSlash() {
        return playerNorthSlash;
    }

    public Sprite[] getPlayerNorthWalk() {
        return playerNorthWalk;
    }

    public Sprite[] getPlayerSouthSlash() {
        return playerSouthSlash;
    }

    public Sprite[] getPlayerSouthWalk() {
        return playerSouthWalk;
    }

    public Sprite[] getEnemyEastWalk() {
        return enemyEastWalk;
    }

    public Sprite[] getEnemyNorthWalk() {
        return enemyNorthWalk;
    }

    public Sprite[] getEnemySouthWalk() {
        return enemySouthWalk;
    }

    public Sprite[] getCoinFrames() {
        return coinFrames;
    }

    // Sprites
    public Sprite getBg1() {
        return bg1;
    }

    public Sprite getBg2() {
        return bg2;
    }

    public Sprite getHex() {
        return hex;
    }

    public Sprite getFactory() {
        return factory;
    }
}