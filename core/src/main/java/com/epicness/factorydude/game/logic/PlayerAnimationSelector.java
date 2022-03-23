package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.Player;

public class PlayerAnimationSelector {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private boolean attacking, walking, facingUp, facingDown, facingLeft, facingRight, idle;

    public void init() {
        logic.getPlayerAnimationUpdater().setup(stuff.getPlayer().getCurrentAnimation());
    }

    public void update() {
        Player player = stuff.getPlayer();
        if (walking) {
            if (facingLeft) {
                player.setFlipX(true);
                player.setCurrentAnimation(player.getEastWalk());
            }
            if (facingRight) {
                player.setFlipX(false);
                player.setCurrentAnimation(player.getEastWalk());
            }
            if (facingUp) {
                player.setCurrentAnimation(player.getNorthWalk());
            }
            if (facingDown) {
                player.setCurrentAnimation(player.getSouthWalk());
            }
        }
        if (attacking) {
            if (facingLeft) {
                player.setFlipX(true);
                player.setCurrentAnimation(player.getEastSlash());
            }
            if (facingRight) {
                player.setFlipX(false);
                player.setCurrentAnimation(player.getEastSlash());
            }
            if (facingUp) {
                player.setCurrentAnimation(player.getNorthSlash());
            }
            if (facingDown) {
                player.setCurrentAnimation(player.getSouthSlash());
            }
        }
        logic.getPlayerAnimationUpdater().setup(stuff.getPlayer().getCurrentAnimation());
    }

    public void translationChange(float xAmount, float yAmount) {
        idle = xAmount == 0f && yAmount == 0f;
        walking = !idle;
        facingUp = yAmount > 0f;
        facingDown = yAmount < 0f;
        facingLeft = xAmount < 0f;
        facingRight = xAmount > 0f;
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}