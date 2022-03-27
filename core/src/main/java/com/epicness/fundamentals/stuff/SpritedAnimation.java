package com.epicness.fundamentals.stuff;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class SpritedAnimation {

    private final Animation<Sprited> animation;
    private float time;

    public SpritedAnimation(Sprite[] spriteFrames, float frameDuration) {
        Sprited[] animationFrames = new Sprited[spriteFrames.length];
        for (int i = 0; i < spriteFrames.length; i++) {
            animationFrames[i] = new Sprited(spriteFrames[i]);
        }
        animation = new Animation<>(frameDuration, animationFrames);
    }

    public void draw(SpriteBatch spriteBatch) {
        animation.getKeyFrame(time).draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        animation.getKeyFrame(time).drawDebug(shapeRenderer);
    }

    public Rectangle getBounds() {
        return animation.getKeyFrame(time).getBoundingRectangle();
    }

    public float getX() {
        return animation.getKeyFrame(time).getX();
    }

    public float getY() {
        return animation.getKeyFrame(time).getY();
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setPosition(x, y);
        }
    }

    public void translate(float xAmount, float yAmount) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].translate(xAmount, yAmount);
        }
    }

    public float getWidth() {
        return animation.getKeyFrame(time).getWidth();
    }

    public float getHeight() {
        return animation.getKeyFrame(time).getHeight();
    }

    public void setSize(float size) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setSize(size, size);
        }
    }

    public void setOriginCenter() {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setOriginCenter();
        }
    }

    public void setScale(float scale) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setScale(scale);
        }
    }

    public void setRotation(float degrees) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setRotation(degrees);
        }
    }

    public boolean isFlipX() {
        return animation.getKeyFrame(time).isFlipX();
    }

    public void setFlip(boolean flipX, boolean flipY) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setFlip(flipX, flipY);
        }
    }

    public void setColor(Color color) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setColor(color);
        }
    }

    public void enableLooping() {
        animation.setPlayMode(LOOP);
    }

    public void addTime(float seconds) {
        time += seconds;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean ended() {
        return animation.isAnimationFinished(time);
    }
}