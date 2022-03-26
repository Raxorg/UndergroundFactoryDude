package com.epicness.factorydude.game.stuff.characters;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.SpriteAnimation;

public class Enemy extends Character {

    private float movementLeft, movementCooldown;

    public Enemy(GameAssets assets) {
        SpriteAnimation eastWalk = new SpriteAnimation(assets.getEnemyEastWalk(), 0.03f);
        eastWalk.enableLooping();

        SpriteAnimation northWalk = new SpriteAnimation(assets.getEnemyNorthWalk(), 0.03f);
        northWalk.enableLooping();

        SpriteAnimation southWalk = new SpriteAnimation(assets.getEnemySouthWalk(), 0.03f);
        southWalk.enableLooping();

        animations = new SpriteAnimation[3];
        animations[0] = eastWalk;
        animations[1] = northWalk;
        animations[2] = southWalk;
        currentAnimation = southWalk;
    }

    public float getMovementLeft() {
        return movementLeft;
    }

    public void affectMovementLeft(float amount) {
        movementLeft += amount;
    }

    public float getMovementCooldown() {
        return movementCooldown;
    }

    public void affectCooldown(float amount) {
        movementCooldown += amount;
    }

    public void useEastWalk() {
        currentAnimation = animations[0];
    }

    public void useNorthWalk() {
        currentAnimation = animations[1];
    }

    public void useSouthWalk() {
        currentAnimation = animations[2];
    }
}