package com.epicness.factorydude.game.logic.enemies;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.GameStuff;
import com.epicness.factorydude.game.stuff.characters.Enemy;

public class EnemySpawner {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;

    public void spawnEnemy() {
        Enemy enemy = new Enemy(assets);
        enemy.translate(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);
        stuff.getEnemies().add(enemy);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}