package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

public class Factory implements Cellable {

    private final Sprited factory;

    public Factory(Sprite factorySprite) {
        factory = new Sprited(factorySprite);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        factory.draw(spriteBatch);
    }

    @Override
    public void setPosition(float x, float y) {
        factory.setPosition(x, y + 20f);
    }

    @Override
    public void setOriginCenter() {
        factory.setOriginCenter();
    }

    @Override
    public void setScale(float scale) {
        factory.setScale(scale);
    }

    @Override
    public float getSize() {
        return factory.getWidth();
    }
}