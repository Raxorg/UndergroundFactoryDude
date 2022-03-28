package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

public abstract class StaticCellable implements Cellable {

    private final Sprited sprited;

    public StaticCellable(Sprite sprite) {
        sprited = new Sprited(sprite);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    @Override
    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
    }

    @Override
    public void setOriginCenter() {
        sprited.setOriginCenter();
    }

    @Override
    public void setScale(float scale) {
        sprited.setScale(scale);
    }

    @Override
    public float getSize() {
        return sprited.getWidth();
    }
}