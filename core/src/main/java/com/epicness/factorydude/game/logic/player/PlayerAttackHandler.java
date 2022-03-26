package com.epicness.factorydude.game.logic.player;

import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.logic.SharedLogic;

public class PlayerAttackHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float cooldown;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        cooldown = Math.max(cooldown - delta, 0f);
    }

    public void attack() {
        if (cooldown != 0f) {
            return;
        }
        logic.getPlayerAnimator().attackChange(true);
        cooldown = 1f;
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}