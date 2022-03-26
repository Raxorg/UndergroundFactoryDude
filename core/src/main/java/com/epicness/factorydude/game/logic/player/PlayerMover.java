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
        float xAmount = speed.x * delta, yAmount = speed.y * delta;
        stuff.getPlayer().translate(xAmount, yAmount);
        logic.getPlayerAnimator().translationChange(xAmount, yAmount);
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