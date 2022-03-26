package com.epicness.factorydude.game.logic.enemies;

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
        enemy.affectCooldown(-delta);
        if (enemy.getMovementCooldown() <= 0f) {
            float cooldown = MathUtils.random(2f, 5f);
            enemy.affectCooldown(cooldown - enemy.getMovementCooldown());
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
        enemy.translate(xAmount, yAmount);
        logic.getEnemyAnimator().translationChange(enemy, xAmount, yAmount);
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