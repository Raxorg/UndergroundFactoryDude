package com.epicness.fundamentals.stuff;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteAnimation {

    private final Animation<Sprite> animation;
    private float time;

    public SpriteAnimation(Sprite[] spriteFrames, float frameDuration) {
        Sprite[] animationFrames = new Sprite[spriteFrames.length];
        for (int i = 0; i < spriteFrames.length; i++) {
            animationFrames[i] = new Sprite(spriteFrames[i]);
        }
        animation = new Animation<>(frameDuration, animationFrames);
    }

    public void draw(SpriteBatch spriteBatch) {
        animation.getKeyFrame(time).draw(spriteBatch);
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

    public void setSize(float size) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setSize(size, size);
        }
    }

    public void setFlip(boolean flipX, boolean flipY) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setFlip(flipX, flipY);
        }
    }

    public void addTime(float seconds) {
        time += seconds;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void enableLooping() {
        animation.setPlayMode(LOOP);
    }

    public boolean ended() {
        return animation.isAnimationFinished(time);
    }
}