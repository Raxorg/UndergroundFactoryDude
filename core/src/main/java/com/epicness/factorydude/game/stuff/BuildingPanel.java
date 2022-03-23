package com.epicness.factorydude.game.stuff;

import static com.epicness.factorydude.game.GameConstants.BUILDING_PANEL_HEIGHT;
import static com.epicness.factorydude.game.GameConstants.BUILDING_PANEL_WIDTH;
import static com.epicness.factorydude.game.GameConstants.FACTORY_OPTION_Y;
import static com.epicness.factorydude.game.GameConstants.OPTION_SIZE;
import static com.epicness.factorydude.game.GameConstants.OPTION_X_OFFSET;
import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_50;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;

public class BuildingPanel {

    private final Sprited background;
    private final Sprited factoryOption;

    public BuildingPanel(SharedAssets sharedAssets, GameAssets assets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setSize(BUILDING_PANEL_WIDTH, BUILDING_PANEL_HEIGHT);
        background.setOriginCenter();
        background.setColor(BLACK_CLEAR_50);

        factoryOption = new Sprited(assets.getFactory());
        factoryOption.setY(FACTORY_OPTION_Y);
        factoryOption.setSize(OPTION_SIZE);
        factoryOption.setOriginCenter();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        factoryOption.draw(spriteBatch);
    }

    public void setX(float x) {
        background.setX(x);
        factoryOption.setX(x + OPTION_X_OFFSET);
    }

    public void setScale(float scale) {
        background.setScale(scale);
        factoryOption.setScale(scale);
    }

    public Sprited getFactoryOption() {
        return factoryOption;
    }
}