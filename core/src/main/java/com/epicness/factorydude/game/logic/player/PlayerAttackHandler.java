package com.epicness.factorydude.game.logic.player;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.logic.GameLogic;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.factorydude.game.stuff.effects.SlashEffect;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.SpritedAnimation;

public class PlayerAttackHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float cooldown;

    public void update(float delta) {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        cooldown = Math.max(cooldown - delta, 0f);
        checkAttackCollision();
    }

    private void checkAttackCollision() {
        DelayedRemovalArray<Enemy> enemies = stuff.getEnemies();
        DelayedRemovalArray<SpritedAnimation> effects = stuff.getEffects();
        enemies.begin();
        enemies:
        for (int i = 0; i < enemies.size; i++) {
            Enemy enemy = enemies.get(i);
            for (int j = 0; j < effects.size; j++) {
                SpritedAnimation effect = effects.get(j);
                if (!(effect instanceof SlashEffect)) {
                    continue;
                }
                if (effect.getBounds().overlaps(enemy.getBounds())) {
                    enemies.removeValue(enemy, true);
                    logic.getCoinHandler().addCoin();
                    logic.getWaveHandler().checkEnemies();
                    break enemies;
                }
            }
        }
        enemies.end();
    }

    public void attack() {
        if (sharedLogic.getPauseTracker().get()) {
            return;
        }
        if (cooldown != 0f) {
            return;
        }
        int attacks = Integer.parseInt(stuff.getPieceCounters().getAttackCounter().getText());
        if (attacks <= 0) {
            return;
        }
        logic.getDestinationHandler().reduceAttack();
        logic.getPlayerAnimator().attackChange(true);
        logic.getEffectHandler().spawnSlash();
        cooldown = 1f;
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