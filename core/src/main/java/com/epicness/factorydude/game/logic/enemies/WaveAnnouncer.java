package com.epicness.factorydude.game.logic.enemies;

import static com.epicness.factorydude.game.GameConstants.HALF_MESSAGE_DURATION;
import static com.epicness.factorydude.game.GameConstants.MESSAGE_DURATION;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.stuff.Text;

public class WaveAnnouncer {

    // Structure
    private GameStuff stuff;
    // Logic
    private boolean showing;
    private float time;

    public void announceWave(int wave) {
        stuff.getMessage().setText("WAVE " + wave);
        time = 0f;
        showing = true;
    }

    public void update(float delta) {
        if (!showing) {
            return;
        }
        time = Math.min(time + delta, MESSAGE_DURATION);
        float progress;
        if (time < HALF_MESSAGE_DURATION) {
            progress = 1f - Interpolation.pow3Out.apply(time / (HALF_MESSAGE_DURATION));
        } else {
            progress = Interpolation.circleIn.apply((time - HALF_MESSAGE_DURATION) / (HALF_MESSAGE_DURATION));
        }
        Text message = stuff.getMessage();
        message.setScale(Math.min(1f + Interpolation.pow5Out.apply(time / MESSAGE_DURATION) * 6f, 7f));
        message.setColor(Color.RED.cpy().lerp(Color.CLEAR, progress));
        if (time == MESSAGE_DURATION) {
            showing = false;
        }
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}