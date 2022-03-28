package com.epicness.factorydude.game;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
import static com.epicness.factorydude.game.GameConstants.DEBUG;

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
        stuff.getFloor().draw(spriteBatch);
        for (int i = 0; i < stuff.getEnemies().size; i++) {
            stuff.getEnemies().get(i).draw(spriteBatch);
        }
        stuff.getPlayer().draw(spriteBatch);
        for (int i = 0; i < stuff.getBullets().size; i++) {
            stuff.getBullets().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getEffects().size; i++) {
            stuff.getEffects().get(i).draw(spriteBatch);
        }

        useStaticCamera();
        stuff.getMessage().draw(spriteBatch);
        stuff.getFactoryZone().draw(spriteBatch);
        stuff.getCursor().draw(spriteBatch);
        stuff.getOverlay().draw(spriteBatch);
        stuff.getCoinCounter().draw(spriteBatch);
        stuff.getDamageOverlay().draw(spriteBatch);
        spriteBatch.end();

        if (DEBUG) {
            renderDebug(stuff);
        }
    }

    private void renderDebug(GameStuff stuff) {
        shapeRenderer.begin();
        useDynamicCamera();
        for (int i = 0; i < stuff.getEnemies().size; i++) {
            stuff.getEnemies().get(i).drawDebug(shapeRenderer);
        }
        stuff.getPlayer().drawDebug(shapeRenderer);
        shapeRenderer.set(Line);
        for (int i = 0; i < stuff.getBullets().size; i++) {
            stuff.getBullets().get(i).drawDebug(shapeRenderer);
        }
        for (int i = 0; i < stuff.getEffects().size; i++) {
            stuff.getEffects().get(i).drawDebug(shapeRenderer);
        }
        shapeRenderer.end();
    }
}