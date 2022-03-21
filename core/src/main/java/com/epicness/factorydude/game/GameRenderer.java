package com.epicness.factorydude.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

public class GameRenderer extends Renderer {

    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(Color.NAVY);
        spriteBatch.begin();
        stuff.getPlayer().draw(spriteBatch);
        stuff.getFactoryZone().draw(spriteBatch);
        spriteBatch.end();
    }
}