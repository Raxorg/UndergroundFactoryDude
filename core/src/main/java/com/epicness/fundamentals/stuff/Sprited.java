package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;
import com.epicness.fundamentals.stuff.interfaces.Parallaxable;

public class Sprited implements Buttonable, Parallaxable {

    private final Sprite sprite;

    public Sprited(Sprite sprite) {
        this.sprite = new Sprite(sprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        Rectangle bounds = sprite.getBoundingRectangle();
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void setSprite(Sprite sprite) {
        this.sprite.set(sprite);
    }

    @Override
    public boolean contains(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    @Override
    public void translateX(float amount) {
        sprite.translateX(amount);
    }

    public Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }

    public float getX() {
        return sprite.getX();
    }

    public void setX(float x) {
        sprite.setX(x);
    }

    public float getY() {
        return sprite.getY();
    }

    public void setY(float y) {
        sprite.setY(y);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public void setOriginBasedPosition(float x, float y) {
        sprite.setOriginBasedPosition(x, y);
    }

    public void translate(float xAmount, float yAmount) {
        sprite.translate(xAmount, yAmount);
    }

    public void translateY(float amount) {
        sprite.translateY(amount);
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
    }

    public void setSize(float size) {
        setSize(size, size);
    }

    public float getScale() {
        return sprite.getScaleX();
    }

    public void setScale(float scale) {
        sprite.setScale(scale);
    }

    public void setOriginCenter() {
        sprite.setOriginCenter();
    }

    public float getRotation() {
        return sprite.getRotation();
    }

    public void setRotation(float degrees) {
        sprite.setRotation(degrees);
    }

    public boolean isFlipX() {
        return sprite.isFlipX();
    }

    public boolean isFlipY() {
        return sprite.isFlipY();
    }

    public void setFlip(boolean flipX, boolean flipY) {
        sprite.setFlip(flipX, flipY);
    }

    public Color getColor() {
        return sprite.getColor();
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }

    public Vector2 getCenter() {
        return sprite.getBoundingRectangle().getCenter(new Vector2());
    }
}