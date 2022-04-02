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
import com.epicness.factorydude.game.stuff.factoryzone.FactoryZone;
import com.epicness.factorydude.game.stuff.hud.CoinCounter;
import com.epicness.factorydude.game.stuff.hud.PieceCounters;
import com.epicness.factorydude.game.stuff.waves.WaveStorage;
import com.epicness.fundamentals.stuff.Sprited;
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
    private Text message;
    private FactoryZone factoryZone;
    private SpritedAnimation cursor;
    private Sprited overlay;
    private CoinCounter coinCounter;
    private PieceCounters pieceCounters;
    private Sprited damageOverlay;

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

        message = new Text(assets.getTimesSquare());
        message.setY(CAMERA_HEIGHT / 2f);
        message.setTextTargetWidth(CAMERA_WIDTH);
        message.setHorizontalAlignment(Align.center);
        message.setCenterVertical(true);

        factoryZone = new FactoryZone(sharedAssets, assets);

        cursor = new SpritedAnimation(assets.getCursorFrames(), 0.05f);
        cursor.enableLooping();

        overlay = new Sprited(assets.getOverlay());
        coinCounter = new CoinCounter(sharedAssets.getPixel(), assets.getCoinFrames(), sharedAssets.getTimesSquare());
        pieceCounters = new PieceCounters(sharedAssets, assets);

        damageOverlay = new Sprited(sharedAssets.getPixel());
        damageOverlay.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
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

    public Text getMessage() {
        return message;
    }

    public FactoryZone getFactoryZone() {
        return factoryZone;
    }

    public SpritedAnimation getCursor() {
        return cursor;
    }

    public Sprited getOverlay() {
        return overlay;
    }

    public CoinCounter getCoinCounter() {
        return coinCounter;
    }

    public PieceCounters getPieceCounters() {
        return pieceCounters;
    }

    public Sprited getDamageOverlay() {
        return damageOverlay;
    }
}