package com.epicness.factorydude.game.logic.enemies;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.Bullet;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.fundamentals.logic.SharedLogic;

public class BulletHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        DelayedRemovalArray<Bullet> bullets = stuff.getBullets();
        Player player = stuff.getPlayer();
        boolean collisionHandled = false;
        bullets.begin();
        for (int i = 0; i < bullets.size; i++) {
            Bullet bullet = bullets.get(i);
            bullet.translate(bullet.getSpeed().x, bullet.getSpeed().y);
            bullet.addTime(delta);
            if (collisionHandled) {
                continue;
            }
            if (bullet.collides(player.getBounds())) {
                bullets.removeValue(bullet, true);
                logic.getPlayerDamager().showDamage();
                collisionHandled = true;
            }
        }
        bullets.end();
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