package com.epicness.factorydude.game.logic;

import static com.epicness.factorydude.game.GameConstants.PLAYER_SPEED;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.logic.SharedLogic;

public class PlayerMover {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float xSpeed, ySpeed;

    public void horizontalDirChange(boolean left, boolean press) {
        float speed = press ? PLAYER_SPEED : -PLAYER_SPEED;
        xSpeed = left ? xSpeed - speed : xSpeed + speed;
    }

    public void verticalDirChange(boolean up, boolean press) {
        float speed = press ? PLAYER_SPEED : -PLAYER_SPEED;
        ySpeed = up ? ySpeed + speed : ySpeed - speed;
    }

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        float xAmount = xSpeed * delta, yAmount = ySpeed * delta;
        stuff.getPlayer().translate(xAmount, yAmount);
        logic.getPlayerAnimationSelector().translationChange(xAmount, yAmount);
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