package com.epicness.factorydude.game.stuff.characters;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.SpriteAnimation;

public class Player extends Character {

    public Player(GameAssets assets) {
        SpriteAnimation eastSlash = new SpriteAnimation(assets.getPlayerEastSlash(), 0.03f);
        SpriteAnimation eastWalk = new SpriteAnimation(assets.getPlayerEastWalk(), 0.03f);
        eastWalk.enableLooping();

        SpriteAnimation northSlash = new SpriteAnimation(assets.getPlayerNorthSlash(), 0.03f);
        SpriteAnimation northWalk = new SpriteAnimation(assets.getPlayerNorthWalk(), 0.03f);
        northWalk.enableLooping();

        SpriteAnimation southSlash = new SpriteAnimation(assets.getPlayerSouthSlash(), 0.03f);
        SpriteAnimation southWalk = new SpriteAnimation(assets.getPlayerSouthWalk(), 0.03f);
        southWalk.enableLooping();

        animations = new SpriteAnimation[6];
        animations[0] = eastSlash;
        animations[1] = eastWalk;
        animations[2] = northSlash;
        animations[3] = northWalk;
        animations[4] = southSlash;
        animations[5] = southWalk;
        currentAnimation = southWalk;
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