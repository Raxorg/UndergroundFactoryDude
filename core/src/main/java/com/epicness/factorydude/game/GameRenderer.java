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
        useDynamicCamera();
        stuff.getBackground().draw(spriteBatch);
        for (int i = 0; i < stuff.getEnemies().size; i++) {
            stuff.getEnemies().get(i).draw(spriteBatch);
        }
        stuff.getPlayer().draw(spriteBatch);
        for (int i = 0; i < stuff.getEffects().size; i++) {
            stuff.getEffects().get(i).draw(spriteBatch);
        }

        useStaticCamera();
        stuff.getFactoryZone().draw(spriteBatch);
        stuff.getCoinCounter().draw(spriteBatch);
        spriteBatch.end();

        renderDebug(stuff);
    }

    private void renderDebug(GameStuff stuff) {
        shapeRenderer.begin();
        useDynamicCamera();
        for (int i = 0; i < stuff.getEnemies().size; i++) {
            stuff.getEnemies().get(i).drawDebug(shapeRenderer);
        }
        stuff.getPlayer().drawDebug(shapeRenderer);
        for (int i = 0; i < stuff.getEffects().size; i++) {
            stuff.getEffects().get(i).drawDebug(shapeRenderer);
        }
        shapeRenderer.end();
    }
}