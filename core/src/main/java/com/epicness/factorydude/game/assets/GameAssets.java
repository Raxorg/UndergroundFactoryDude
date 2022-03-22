package com.epicness.factorydude.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.factorydude.game.assets.GameAssetPaths.HEX_PATH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_EAST_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_EAST_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_NORTH_SLASH;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_NORTH_WALK;
import static com.epicness.factorydude.game.assets.GameAssetPaths.PLAYER_PATH;
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
    // Sprites
    private Sprite hex;
    private Sprite player;

    @Override
    public void queueAssetLoading() {
        loadTexture(PLAYER_EAST_SLASH);
        loadTexture(PLAYER_EAST_WALK);
        loadTexture(PLAYER_NORTH_SLASH);
        loadTexture(PLAYER_NORTH_WALK);
        loadTexture(PLAYER_SOUTH_SLASH);
        loadTexture(PLAYER_SOUTH_WALK);
        loadTexture(HEX_PATH);
        loadTexture(PLAYER_PATH);
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
        // Sprites
        hex = new Sprite(getTexture(HEX_PATH));
        hex.getTexture().setFilter(Linear, Linear);
        player = new Sprite(getTexture(PLAYER_PATH));
        player.getTexture().setFilter(Linear, Linear);
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

    // Sprites
    public Sprite getHex() {
        return hex;
    }

    public Sprite getPlayer() {
        return player;
    }
}