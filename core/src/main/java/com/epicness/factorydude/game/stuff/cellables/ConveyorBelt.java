package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class ConveyorBelt implements Cellable {

    private final SpritedAnimation animation;

    public ConveyorBelt(Sprite[] conveyorFrames) {
        animation = new SpritedAnimation(conveyorFrames, 0.25f);
        animation.setSize(75f);
        animation.enableLooping();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        animation.draw(spriteBatch);
    }

    @Override
    public void setPosition(float x, float y) {
        animation.setPosition(x, y);
    }

    @Override
    public void setOriginCenter() {
        animation.setOriginCenter();
    }

    @Override
    public void setScale(float scale) {
        animation.setScale(scale);
    }

    @Override
    public float getSize() {
        return animation.getWidth();
    }

    public void addTime(float time) {
        animation.addTime(time);
    }

    public float getRotation() {
        return animation.getRotation();
    }

    public void setRotation(float degrees) {
        animation.setRotation(degrees);
    }
}