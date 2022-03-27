package com.epicness.factorydude.game.stuff.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public abstract class Character {

    protected SpritedAnimation[] animations;
    protected SpritedAnimation currentAnimation;
    private boolean facingUp, facingDown, facingLeft, facingRight;
    private final Vector2 speed;
    protected Rectangle bounds;

    public Character() {
        facingDown = true;
        speed = new Vector2();
    }

    public void draw(SpriteBatch spriteBatch) {
        currentAnimation.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        currentAnimation.drawDebug(shapeRenderer);
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public float getX() {
        return currentAnimation.getX();
    }

    public float getY() {
        return currentAnimation.getY();
    }

    public void translate(float xAmount, float yAmount) {
        for (int i = 0; i < animations.length; i++) {
            animations[i].translate(xAmount, yAmount);
        }
        bounds.x += xAmount;
        bounds.y += yAmount;
    }

    public float getWidth() {
        return currentAnimation.getWidth();
    }

    public float getHeight() {
        return currentAnimation.getHeight();
    }

    public float getCenterX() {
        return getX() + getWidth() / 2f;
    }

    public float getCenterY() {
        return getY() + getHeight() / 2f;
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

    public boolean isFlipX() {
        return currentAnimation.isFlipX();
    }

    public void setFlipX(boolean flipX) {
        for (int i = 0; i < animations.length; i++) {
            animations[i].setFlip(flipX, false);
        }
    }

    public boolean isFacingUp() {
        return facingUp;
    }

    public void setFacingUp(boolean facingUp) {
        this.facingUp = facingUp;
    }

    public boolean isFacingDown() {
        return facingDown;
    }

    public void setFacingDown(boolean facingDown) {
        this.facingDown = facingDown;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}