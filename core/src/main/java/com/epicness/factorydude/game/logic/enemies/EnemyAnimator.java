package com.epicness.factorydude.game.logic.enemies;

import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.utils.AngleUtils;

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
        boolean idle = xAmount == 0f && yAmount == 0f;
        if (idle) {
            Player player = stuff.getPlayer();
            float playerX = player.getX(), playerY = player.getY();
            float enemyX = enemy.getX(), enemyY = enemy.getY();
            float angle = AngleUtils.degreesBetweenPoints(enemyX, enemyY, playerX, playerY);
            if ((angle < 0f && angle > -45f) || (angle > 0f && angle < 45f)) {
                enemy.setFacingUp(false);
                enemy.setFacingDown(false);
                enemy.setFacingLeft(true);
            } else if (angle > 45f && angle < 135.0f) {
                enemy.setFacingDown(true);
            } else if (angle < -45f && angle > -135.0f) {
                enemy.setFacingDown(false);
                enemy.setFacingUp(true);
            } else {
                enemy.setFacingUp(false);
                enemy.setFacingDown(false);
                enemy.setFacingLeft(false);
                enemy.setFacingRight(true);
            }
            enemy.setAnimationTime(0.03f * 8f);
            return;
        }
        boolean biggerY = Math.abs(yAmount) >= Math.abs(xAmount);
        enemy.setFacingUp(biggerY && yAmount > 0f);
        enemy.setFacingDown(biggerY && yAmount < 0f);
        enemy.setFacingLeft(!biggerY && xAmount < 0f);
        enemy.setFacingRight(!biggerY && xAmount > 0f);
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}