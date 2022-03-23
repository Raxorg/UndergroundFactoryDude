package com.epicness.factorydude.game.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class Player {

    private final SpritedAnimation eastSlash, eastWalk, northSlash, northWalk, southSlash, southWalk;
    private final SpritedAnimation[] animations;
    private SpritedAnimation currentAnimation;

    public Player(GameAssets assets) {
        eastSlash = new SpritedAnimation(assets.getPlayerEastSlash(), 0.03f);
        eastWalk = new SpritedAnimation(assets.getPlayerEastWalk(), 0.03f);
        northSlash = new SpritedAnimation(assets.getPlayerNorthSlash(), 0.03f);
        northWalk = new SpritedAnimation(assets.getPlayerNorthWalk(), 0.03f);
        southSlash = new SpritedAnimation(assets.getPlayerSouthSlash(), 0.03f);
        southWalk = new SpritedAnimation(assets.getPlayerSouthWalk(), 0.03f);
        animations = new SpritedAnimation[6];
        animations[0] = eastSlash;
        animations[1] = eastWalk;
        animations[2] = northSlash;
        animations[3] = northWalk;
        animations[4] = southSlash;
        animations[5] = southWalk;
        for (int i = 0; i < animations.length; i++) {
            animations[i].enableLooping();
        }
        currentAnimation = eastSlash;
    }

    public void draw(SpriteBatch spriteBatch) {
        currentAnimation.draw(spriteBatch);
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

    public SpritedAnimation getEastSlash() {
        return eastSlash;
    }

    public SpritedAnimation getEastWalk() {
        return eastWalk;
    }

    public SpritedAnimation getNorthSlash() {
        return northSlash;
    }

    public SpritedAnimation getNorthWalk() {
        return northWalk;
    }

    public SpritedAnimation getSouthSlash() {
        return southSlash;
    }

    public SpritedAnimation getSouthWalk() {
        return southWalk;
    }

    public SpritedAnimation getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(SpritedAnimation currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
}