package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

public class Cellable {

    private final Sprited sprited;

    public Cellable(Sprite cellableSprite) {
        sprited = new Sprited(cellableSprite);
        sprited.setOriginCenter();
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
    }

    public void setScale(float scale) {
        sprited.setScale(scale);
    }
}