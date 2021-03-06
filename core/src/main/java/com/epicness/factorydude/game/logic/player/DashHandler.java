package com.epicness.factorydude.game.logic.player;

import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;

public class DashHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float cooldown, duration;

    public void init() {
        logic.getPlayerMover().setSpeedMultiplier(1f);
    }

    public void dash() {
        if (cooldown > 0f) {
            return;
        }
        int dashes = Integer.parseInt(stuff.getPieceCounters().getDashCounter().getText());
        if (dashes <= 0) {
            return;
        }
        logic.getDestinationHandler().reduceDash();
        stuff.getPieceCounters().getDashCounter().setText(--dashes + "");
        logic.getEffectHandler().spawnDash();
        cooldown = 2f;
        duration = 0.3f;
        logic.getPlayerMover().setSpeedMultiplier(3f);
    }

    public void update(float delta) {
        cooldown = Math.max(cooldown - delta, 0f);
        duration = Math.max(duration - delta, 0f);
        if (duration == 0f) {
            logic.getPlayerMover().setSpeedMultiplier(1f);
        }
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}