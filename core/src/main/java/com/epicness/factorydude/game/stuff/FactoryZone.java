package com.epicness.factorydude.game.stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;

public class FactoryZone {

    private final Sprited background;
    private final Sprited factory;

    public FactoryZone(SharedAssets sharedAssets, GameAssets assets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        background.setOriginCenter();
        background.setScale(0f);

        factory = new Sprited(sharedAssets.getPixel());
        factory.setPosition(200f, 200f);
        factory.setSize(100f, 100f);
        factory.setOriginCenter();
        factory.setScale(0f);
        factory.setColor(Color.GREEN);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        factory.draw(spriteBatch);
    }

    public void setScale(float scale) {
        background.setScale(scale);
        factory.setScale(scale);
    }
}