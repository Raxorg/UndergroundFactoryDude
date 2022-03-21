package com.epicness.factorydude.game.logic;

import static com.epicness.factorydude.game.GameConstants.PLAYER_SPEED;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.fundamentals.logic.SharedLogic;

public class PlayerHandler {

    // Structure
    private SharedLogic sharedLogic;
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
        stuff.getPlayer().translateX(xSpeed * delta);
        stuff.getPlayer().translateY(ySpeed * delta);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}