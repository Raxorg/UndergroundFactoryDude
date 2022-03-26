package com.epicness.factorydude.game.logic.enemies;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.fundamentals.logic.SharedLogic;

public class EnemyAnimator {

    // Structure
    private SharedLogic sharedLogic;
    private GameStuff stuff;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        for (int i = 0; i < stuff.getEnemies().size; i++) {
            Enemy enemy = stuff.getEnemies().get(i);
            if (enemy.isFacingLeft() || enemy.isFacingRight()) {
                enemy.setFlipX(enemy.isFacingLeft());
                enemy.useEastWalk();
            }
            if (enemy.isFacingUp()) {
                enemy.useNorthWalk();
            }
            if (enemy.isFacingDown()) {
                enemy.useSouthWalk();
            }
            enemy.addAnimationTime(delta);
        }
    }

    public void translationChange(Enemy enemy, float xAmount, float yAmount) {
        boolean idle = enemy.setIdle(xAmount == 0f && yAmount == 0f);
        boolean biggerY = Math.abs(yAmount) >= Math.abs(xAmount);
        enemy.setFacingUp(biggerY && yAmount > 0f || (enemy.isFacingUp() && idle));
        enemy.setFacingDown(biggerY && yAmount < 0f || (enemy.isFacingDown() && idle));
        enemy.setFacingLeft(!biggerY && xAmount < 0f || (enemy.isFacingLeft() && idle));
        enemy.setFacingRight(!biggerY && xAmount > 0f || (enemy.isFacingRight() && idle));
        if (idle) {
            enemy.setAnimationTime(0.03f * 8f);
        }
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}