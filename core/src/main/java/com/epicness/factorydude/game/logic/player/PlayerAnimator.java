package com.epicness.factorydude.game.logic.player;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.fundamentals.logic.SharedLogic;

public class PlayerAnimator {

    // Structure
    private SharedLogic sharedLogic;
    private GameStuff stuff;
    // Logic
    private boolean attacking;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        Player player = stuff.getPlayer();
        boolean facingLeft = player.isFacingLeft();
        boolean facingRight = player.isFacingRight();
        boolean facingUp = player.isFacingUp();
        boolean facingDown = player.isFacingDown();
        if (facingLeft || facingRight) {
            player.setFlipX(facingLeft);
            player.useEastWalk();
        }
        if (facingUp) {
            player.useNorthWalk();
        }
        if (facingDown) {
            player.useSouthWalk();
        }
        if (attacking) {
            if (facingLeft || facingRight) {
                player.setFlipX(facingLeft);
                player.useEastSlash();
            }
            if (facingUp) {
                player.useNorthSlash();
            }
            if (facingDown) {
                player.useSouthSlash();
            }
            if (player.isAnimationFinished()) {
                attacking = false;
            }
        }
        player.addAnimationTime(delta);
    }

    public void translationChange(float xAmount, float yAmount) {
        boolean idle = xAmount == 0f && yAmount == 0f;
        if (attacking) {
            return;
        }
        Player player = stuff.getPlayer();
        player.setFacingUp(yAmount > 0f || (player.isFacingUp() && idle));
        player.setFacingDown(yAmount < 0f || (player.isFacingDown() && idle));
        player.setFacingLeft(xAmount < 0f || (player.isFacingLeft() && idle));
        player.setFacingRight(xAmount > 0f || (player.isFacingRight() && idle));
        if (idle) {
            stuff.getPlayer().setAnimationTime(0.03f * 8f);
        }
    }

    public void attackChange(boolean attacking) {
        this.attacking = attacking;
        stuff.getPlayer().setAnimationTime(0f);
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}