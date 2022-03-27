package com.epicness.factorydude.game.stuff.cellables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Cellable {

    void draw(SpriteBatch spriteBatch);

    void setPosition(float x, float y);

    void setOriginCenter();

    void setScale(float scale);

    float getSize();
}