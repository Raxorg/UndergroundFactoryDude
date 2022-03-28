package com.epicness.factorydude.game.logic.other;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.stuff.Text;

public class GameOverHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private boolean showing;
    private float progress;

    public void showVictory() {
        stuff.getMessage().setText("VICTORY!!!");
        showing = true;
    }

    public void showDefeat() {
        stuff.getMessage().setText("DEFEAT!!!");
        showing = true;
    }

    public void update(float delta) {
        if (!showing) {
            return;
        }
        progress = Math.min(progress + delta, 1f);
        Text message = stuff.getMessage();
        message.setScale(Interpolation.linear.apply(progress) * 6f);
        message.setColor(Color.GREEN.cpy().lerp(Color.CLEAR, 1f - progress));
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}