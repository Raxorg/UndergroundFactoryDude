package com.epicness.factorydude.game.logic;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.fundamentals.logic.SharedLogic;

public class PlayerAnimator {

    // Structure
    private SharedLogic sharedLogic;
    private GameStuff stuff;
    // Logic
    private boolean attacking, facingUp, facingDown, facingLeft, facingRight, idle;

    public void init() {
        idle = true;
        facingDown = true;
    }

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        Player player = stuff.getPlayer();
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
        idle = xAmount == 0f && yAmount == 0f;
        if (attacking) {
            return;
        }
        facingUp = yAmount > 0f || (facingUp && idle);
        facingDown = yAmount < 0f || (facingDown && idle);
        facingLeft = xAmount < 0f || (facingLeft && idle);
        facingRight = xAmount > 0f || (facingRight && idle);
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