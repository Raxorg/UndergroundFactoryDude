package com.epicness.factorydude.game.logic.player;

import static com.epicness.factorydude.game.GameConstants.PLAYER_SPEED;

import com.badlogic.gdx.math.Vector2;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.logic.SharedLogic;

public class PlayerMover {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float speedMultiplier;

    public void horizontalDirChange(boolean left, boolean press) {
        float speedChange = press ? PLAYER_SPEED : -PLAYER_SPEED;
        Vector2 speed = stuff.getPlayer().getSpeed();
        speed.x = left ? speed.x - speedChange : speed.x + speedChange;
    }

    public void verticalDirChange(boolean up, boolean press) {
        float speedChange = press ? PLAYER_SPEED : -PLAYER_SPEED;
        Vector2 speed = stuff.getPlayer().getSpeed();
        speed.y = up ? speed.y + speedChange : speed.y - speedChange;
    }

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        Vector2 speed = stuff.getPlayer().getSpeed();
        Vector2 clamped = new Vector2(speed).clamp(0f, PLAYER_SPEED);
        float xAmount = clamped.x * delta, yAmount = clamped.y * delta;
        stuff.getPlayer().translate(xAmount * speedMultiplier, yAmount * speedMultiplier);
        logic.getPlayerAnimator().translationChange(xAmount, yAmount);
    }

    public void setSpeedMultiplier(float speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
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