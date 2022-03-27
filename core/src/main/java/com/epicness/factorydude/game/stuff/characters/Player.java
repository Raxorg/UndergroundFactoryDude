package com.epicness.factorydude.game.stuff.characters;

import static com.epicness.factorydude.game.GameConstants.FLOOR_HEIGHT;
import static com.epicness.factorydude.game.GameConstants.FLOOR_WIDTH;

import com.badlogic.gdx.math.Rectangle;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class Player extends Character {

    public Player(GameAssets assets) {
        SpritedAnimation eastWalk = new SpritedAnimation(assets.getPlayerEastWalk(), 0.03f);
        SpritedAnimation northWalk = new SpritedAnimation(assets.getPlayerNorthWalk(), 0.03f);
        SpritedAnimation southWalk = new SpritedAnimation(assets.getPlayerSouthWalk(), 0.03f);
        eastWalk.enableLooping();
        northWalk.enableLooping();
        southWalk.enableLooping();

        SpritedAnimation eastSlash = new SpritedAnimation(assets.getPlayerEastSlash(), 0.03f);
        SpritedAnimation northSlash = new SpritedAnimation(assets.getPlayerNorthSlash(), 0.03f);
        SpritedAnimation southSlash = new SpritedAnimation(assets.getPlayerSouthSlash(), 0.03f);

        animations = new SpritedAnimation[6];
        animations[0] = eastSlash;
        animations[1] = eastWalk;
        animations[2] = northSlash;
        animations[3] = northWalk;
        animations[4] = southSlash;
        animations[5] = southWalk;
        currentAnimation = southWalk;

        float width = getWidth() * 0.2f;
        float height = getHeight() * 0.35f;
        bounds = new Rectangle(
                getWidth() / 2f - width / 2f, getHeight() / 2f - height / 2f,
                width, height);

        translate(FLOOR_WIDTH / 2f, FLOOR_HEIGHT / 2f);
    }

    public void useEastSlash() {
        currentAnimation = animations[0];
    }

    public void useEastWalk() {
        currentAnimation = animations[1];
    }

    public void useNorthSlash() {
        currentAnimation = animations[2];
    }

    public void useNorthWalk() {
        currentAnimation = animations[3];
    }

    public void useSouthSlash() {
        currentAnimation = animations[4];
    }

    public void useSouthWalk() {
        currentAnimation = animations[5];
    }
}