package com.epicness.factorydude.game.logic.player;

import com.badlogic.gdx.graphics.Color;
import com.epicness.factorydude.game.stuff.GameStuff;

public class PlayerDamager {

    // Structure
    private GameStuff stuff;
    // Logic
    private boolean showing;
    private float progress;

    public void init() {
        stuff.getDamageOverlay().setColor(Color.CLEAR);
    }

    public void showDamage() {
        showing = true;
        progress = 0f;
    }

    public void update(float delta) {
        if (!showing) {
            return;
        }
        progress = Math.min(progress + delta, 1f);
        stuff.getDamageOverlay().setColor(Color.RED.cpy().lerp(Color.CLEAR, progress));
        if (progress == 1f) {
            showing = false;
        }
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}