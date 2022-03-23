package com.epicness.factorydude.game.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class Player {

    private final SpritedAnimation[] animations;
    private SpritedAnimation currentAnimation;

    public Player(GameAssets assets) {
        SpritedAnimation eastSlash = new SpritedAnimation(assets.getPlayerEastSlash(), 0.03f);
        SpritedAnimation eastWalk = new SpritedAnimation(assets.getPlayerEastWalk(), 0.03f);
        eastWalk.enableLooping();

        SpritedAnimation northSlash = new SpritedAnimation(assets.getPlayerNorthSlash(), 0.03f);
        SpritedAnimation northWalk = new SpritedAnimation(assets.getPlayerNorthWalk(), 0.03f);
        northWalk.enableLooping();

        SpritedAnimation southSlash = new SpritedAnimation(assets.getPlayerSouthSlash(), 0.03f);
        SpritedAnimation southWalk = new SpritedAnimation(assets.getPlayerSouthWalk(), 0.03f);
        southWalk.enableLooping();

        animations = new SpritedAnimation[6];
        animations[0] = eastSlash;
        animations[1] = eastWalk;
        animations[2] = northSlash;
        animations[3] = northWalk;
        animations[4] = southSlash;
        animations[5] = southWalk;
        currentAnimation = southWalk;
    }

    public void draw(SpriteBatch spriteBatch) {
        currentAnimation.draw(spriteBatch);
    }

    public void addAnimationTime(float time) {
        for (int i = 0; i < animations.length; i++) {
            animations[i].addTime(time);
        }
    }

    public void setAnimationTime(float time) {
        for (int i = 0; i < animations.length; i++) {
            animations[i].setTime(time);
        }
    }

    public boolean isAnimationFinished() {
        return currentAnimation.ended();
    }

    public void translate(float xAmount, float yAmount) {
        for (int i = 0; i < animations.length; i++) {
            animations[i].translate(xAmount, yAmount);
        }
    }

    public void setFlipX(boolean flipX) {
        for (int i = 0; i < animations.length; i++) {
            animations[i].setFlip(flipX, false);
        }
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