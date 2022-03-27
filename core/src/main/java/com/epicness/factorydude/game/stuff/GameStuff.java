package com.epicness.factorydude.game.stuff;

import static com.epicness.factorydude.game.GameConstants.FLOOR_COLUMNS;
import static com.epicness.factorydude.game.GameConstants.FLOOR_ROWS;
import static com.epicness.factorydude.game.GameConstants.TILE_SIZE;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.factorydude.game.assets.GameAssets;
import com.epicness.factorydude.game.stuff.characters.Enemy;
import com.epicness.factorydude.game.stuff.characters.Player;
import com.epicness.factorydude.game.stuff.hud.CoinCounter;
import com.epicness.factorydude.game.stuff.waves.WaveStorage;
import com.epicness.fundamentals.stuff.SpritedAnimation;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.grid.Grid;

public class GameStuff extends Stuff {

    private WaveStorage waveStorage;
    private Grid floor;
    private DelayedRemovalArray<Enemy> enemies;
    private Player player;
    private DelayedRemovalArray<Bullet> bullets;
    private DelayedRemovalArray<SpritedAnimation> effects;
    private Text waveMessage;
    private FactoryZone factoryZone;
    private CoinCounter coinCounter;
    private SpritedAnimation cursor;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        waveStorage = new WaveStorage();

        floor = new Grid(FLOOR_COLUMNS, FLOOR_ROWS, assets.getBg1());
        floor.setCellSize(TILE_SIZE);

        enemies = new DelayedRemovalArray<>();
        player = new Player(assets);
        bullets = new DelayedRemovalArray<>();
        effects = new DelayedRemovalArray<>();

        waveMessage = new Text(assets.getTimesSquare());
        waveMessage.setY(CAMERA_HEIGHT / 2f);
        waveMessage.setTextTargetWidth(CAMERA_WIDTH);
        waveMessage.setHorizontalAlignment(Align.center);
        waveMessage.setCenterVertical(true);

        factoryZone = new FactoryZone(sharedAssets, assets);
        coinCounter = new CoinCounter(sharedAssets.getPixel(), assets.getCoinFrames(), sharedAssets.getTimesSquare());

        cursor = new SpritedAnimation(assets.getCursorFrames(), 0.05f);
        cursor.enableLooping();
    }

    public WaveStorage getWaveStorage() {
        return waveStorage;
    }

    public Grid getFloor() {
        return floor;
    }

    public DelayedRemovalArray<Enemy> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public DelayedRemovalArray<Bullet> getBullets() {
        return bullets;
    }

    public DelayedRemovalArray<SpritedAnimation> getEffects() {
        return effects;
    }

    public Text getWaveMessage() {
        return waveMessage;
    }

    public FactoryZone getFactoryZone() {
        return factoryZone;
    }

    public CoinCounter getCoinCounter() {
        return coinCounter;
    }

    public SpritedAnimation getCursor() {
        return cursor;
    }
}