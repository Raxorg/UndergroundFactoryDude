package com.epicness.factorydude.game.logic.enemies;

import static com.epicness.factorydude.game.GameConstants.BULLET_BOUNDS_RADIUS;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.Bullet;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.fundamentals.utils.AngleUtils;

public class EnemyAttackHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Enemy> enemies = stuff.getEnemies();
        for (int i = 0; i < enemies.size; i++) {
            Enemy enemy = enemies.get(i);
            enemy.affectAttackCooldown(-delta);
            if (enemy.getAttackCooldown() <= 0f) {
                shoot(enemy);
                enemy.affectAttackCooldown(5f - enemy.getAttackCooldown());
            }
        }
    }

    private void shoot(Enemy enemy) {
        Bullet bullet = new Bullet(assets.getBulletFrames());
        bullet.setPosition(enemy.getCenterX() - BULLET_BOUNDS_RADIUS, enemy.getCenterY() - BULLET_BOUNDS_RADIUS);
        Player player = stuff.getPlayer();
        float angle = AngleUtils.degreesBetweenPoints(player.getX(), player.getY(), enemy.getX(), enemy.getY());
        bullet.getSpeed().x = MathUtils.cosDeg(angle) * 3f;
        bullet.getSpeed().y = MathUtils.sinDeg(angle) * 3f;
        bullet.setColor(Color.RED);
        stuff.getBullets().add(bullet);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}