package com.epicness.factorydude.game.stuff.characters;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class Enemy extends Character {

    private float movementLeft, movementCooldown, attackCooldown;

    public Enemy(GameAssets assets) {
        SpritedAnimation eastWalk = new SpritedAnimation(assets.getEnemyEastWalk(), 0.03f);
        eastWalk.enableLooping();

        SpritedAnimation northWalk = new SpritedAnimation(assets.getEnemyNorthWalk(), 0.03f);
        northWalk.enableLooping();

        SpritedAnimation southWalk = new SpritedAnimation(assets.getEnemySouthWalk(), 0.03f);
        southWalk.enableLooping();

        animations = new SpritedAnimation[3];
        animations[0] = eastWalk;
        animations[1] = northWalk;
        animations[2] = southWalk;
        currentAnimation = southWalk;

        bounds = new Rectangle(getWidth() / 4f, getHeight() / 4f, getWidth() / 2f, getHeight() / 2f);
        attackCooldown = MathUtils.random(3f, 5f);
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

    public void affectMovementCooldown(float amount) {
        movementCooldown += amount;
    }

    public float getAttackCooldown() {
        return attackCooldown;
    }

    public void affectAttackCooldown(float amount) {
        attackCooldown += amount;
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