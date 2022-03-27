package com.epicness.factorydude.game.logic.enemies;

import static com.epicness.factorydude.game.GameConstants.FLOOR_HEIGHT;
import static com.epicness.factorydude.game.GameConstants.FLOOR_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.fundamentals.logic.SharedLogic;

public class EnemyMover {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        DelayedRemovalArray<Enemy> enemies = stuff.getEnemies();
        for (int i = 0; i < enemies.size; i++) {
            reduceMovementCooldown(enemies.get(i), delta);
            move(enemies.get(i), delta);
        }
    }

    private void reduceMovementCooldown(Enemy enemy, float delta) {
        enemy.affectMovementCooldown(-delta);
        if (enemy.getMovementCooldown() <= 0f) {
            float cooldown = MathUtils.random(2f, 5f);
            enemy.affectMovementCooldown(cooldown - enemy.getMovementCooldown());
            enemy.affectMovementLeft(MathUtils.random(0.5f, 1.5f));
            enemy.getSpeed().x = MathUtils.random(-400f, 400f);
            enemy.getSpeed().y = MathUtils.random(-400f, 400f);
            enemy.getSpeed().clamp(150f, 300f);
        }
    }

    private void move(Enemy enemy, float delta) {
        float xAmount = 0f, yAmount = 0f;
        if (enemy.getMovementLeft() <= 0f) {
            enemy.affectMovementLeft(-enemy.getMovementLeft());
            logic.getEnemyAnimator().translationChange(enemy, xAmount, yAmount);
            return;
        }
        enemy.affectMovementLeft(-delta);
        Vector2 speed = enemy.getSpeed();
        xAmount = speed.x * delta;
        yAmount = speed.y * delta;
        checkLimits(enemy, speed, xAmount, yAmount);
        enemy.translate(xAmount, yAmount);
        logic.getEnemyAnimator().translationChange(enemy, xAmount, yAmount);
    }

    private void checkLimits(Enemy enemy, Vector2 speed, float xAmount, float yAmount) {
        if (enemy.getX() + xAmount < 0f) {
            speed.x = -speed.x;
        } else if (enemy.getX() + enemy.getWidth() + xAmount > FLOOR_WIDTH) {
            speed.x = -speed.x;
        }
        if (enemy.getY() + yAmount < 0f) {
            speed.y = -speed.y;
        } else if (enemy.getY() + enemy.getHeight() + yAmount > FLOOR_HEIGHT) {
            speed.y = -speed.y;
        }
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