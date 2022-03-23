package com.epicness.factorydude.game.stuff;

import static com.epicness.factorydude.game.GameConstants.BUILDING_PANEL_HEIGHT;
import static com.epicness.factorydude.game.GameConstants.BUILDING_PANEL_WIDTH;
import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_50;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;

public class BuildingPanel {

    private final Sprited background;

    public BuildingPanel(SharedAssets sharedAssets, GameAssets assets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setSize(BUILDING_PANEL_WIDTH, BUILDING_PANEL_HEIGHT);
        background.setOriginCenter();
        background.setColor(BLACK_CLEAR_50);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
    }

    public void setX(float x) {
        background.setX(x);
    }

    public void setScale(float scale) {
        background.setScale(scale);
    }
}