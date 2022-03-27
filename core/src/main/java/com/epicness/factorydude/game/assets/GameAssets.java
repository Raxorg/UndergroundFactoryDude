package com.epicness.factorydude.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.factorydude.game.assets.GameAssetPaths.BG_1;
import static com.epicness.factorydude.game.assets.GameAssetPaths.BG_2;
import static com.epicness.factorydude.game.assets.GameAssetPaths.BULLET_FRAMES;
import static com.epicness.factorydude.game.assets.GameAssetPaths.COIN_FRAMES;
import static com.epicness.factorydude.game.assets.GameAssetPaths.CONVEYOR_BELT_FRAMES;
import static com.epicness.factorydude.game.assets.GameAssetPaths.CURSOR_FRAMES;
import static com.epicness.factorydude.game.assets.GameAssetPaths.ENEMY_EAST_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.ENEMY_NORTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.ENEMY_SOUTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.FACTORY_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.HEX_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_EAST_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_EAST_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_NORTH_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_NORTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_SOUTH_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_SOUTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.TIMES_SQUARE;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.utils.AnimationUtils;

public class GameAssets extends Assets {

    // Animations
    private Sprite[] playerEastWalk, playerNorthWalk, playerSouthWalk,
            playerEastSlash, playerNorthSlash, playerSouthSlash, playerSlash;
    private Sprite[] enemyEastWalk, enemyNorthWalk, enemySouthWalk,
            bulletFrames;
    private Sprite[] coinFrames, conveyorBeltFrames, cursorFrames;
    // Fonts
    private BitmapFont timesSquare;
    // Sprites
    private Sprite bg1, bg2;
    private Sprite hex;
    private Sprite factory, conveyor;

    @Override
    public void queueAssetLoading() {
        // Animations
        loadTexture(PLAYER_EAST_WALK);
        loadTexture(PLAYER_NORTH_WALK);
        loadTexture(PLAYER_SOUTH_WALK);
        loadTexture(PLAYER_EAST_SLASH);
        loadTexture(PLAYER_NORTH_SLASH);
        loadTexture(PLAYER_SOUTH_SLASH);
        loadTexture(PLAYER_SLASH);
        loadTexture(ENEMY_EAST_WALK);
        loadTexture(ENEMY_NORTH_WALK);
        loadTexture(ENEMY_SOUTH_WALK);
        loadTexture(BULLET_FRAMES);
        loadTexture(COIN_FRAMES);
        loadTexture(CONVEYOR_BELT_FRAMES);
        loadTexture(CURSOR_FRAMES);
        // Fonts
        loadFont(TIMES_SQUARE);
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
        Texture playerSlashTex = getTexture(PLAYER_SLASH);
        playerSlash = AnimationUtils.split(playerSlashTex, 101, 114, 11);

        Texture enemyEastWalkTex = getTexture(ENEMY_EAST_WALK);
        enemyEastWalk = AnimationUtils.split(enemyEastWalkTex, 138, 165, 20);
        Texture enemyNorthWalkTex = getTexture(ENEMY_NORTH_WALK);
        enemyNorthWalk = AnimationUtils.split(enemyNorthWalkTex, 138, 165, 20);
        Texture enemySouthWalkTex = getTexture(ENEMY_SOUTH_WALK);
        enemySouthWalk = AnimationUtils.split(enemySouthWalkTex, 138, 165, 20);
        Texture bulletFramesTex = getTexture(BULLET_FRAMES);
        bulletFrames = AnimationUtils.split(bulletFramesTex, 22, 25, 5);

        Texture coinFramesTex = getTexture(COIN_FRAMES);
        coinFramesTex.setFilter(Linear, Linear);
        coinFrames = AnimationUtils.split(coinFramesTex, 16, 21, 4);

        Texture conveyorFramesTex = getTexture(CONVEYOR_BELT_FRAMES);
        conveyorFramesTex.setFilter(Linear, Linear);
        conveyorBeltFrames = AnimationUtils.split(conveyorFramesTex, 100, 100, 4);

        Texture cursorFramesTex = getTexture(CURSOR_FRAMES);
        cursorFrames = AnimationUtils.split(cursorFramesTex, 69, 69, 15);
        // Fonts
        timesSquare = getFont(TIMES_SQUARE);
        timesSquare.getRegion().getTexture().setFilter(Linear, Linear);
        // Sprites
        bg1 = new Sprite(getTexture(BG_1));
        bg2 = new Sprite(getTexture(BG_2));
        hex = new Sprite(getTexture(HEX_PATH));
        hex.getTexture().setFilter(Linear, Linear);
        factory = new Sprite(getTexture(FACTORY_PATH));
        factory.getTexture().setFilter(Linear, Linear);
        conveyor = new Sprite(conveyorFramesTex, 0, 0, 100, 100);
    }

    // Animations
    public Sprite[] getPlayerEastWalk() {
        return playerEastWalk;
    }

    public Sprite[] getPlayerNorthWalk() {
        return playerNorthWalk;
    }

    public Sprite[] getPlayerSouthWalk() {
        return playerSouthWalk;
    }

    public Sprite[] getPlayerEastSlash() {
        return playerEastSlash;
    }

    public Sprite[] getPlayerNorthSlash() {
        return playerNorthSlash;
    }

    public Sprite[] getPlayerSouthSlash() {
        return playerSouthSlash;
    }

    public Sprite[] getPlayerSlash() {
        return playerSlash;
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

    public Sprite[] getBulletFrames() {
        return bulletFrames;
    }

    public Sprite[] getCoinFrames() {
        return coinFrames;
    }

    public Sprite[] getConveyorBeltFrames() {
        return conveyorBeltFrames;
    }

    public Sprite[] getCursorFrames() {
        return cursorFrames;
    }

    // Fonts
    public BitmapFont getTimesSquare() {
        return timesSquare;
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

    public Sprite getConveyor() {
        return conveyor;
    }
}